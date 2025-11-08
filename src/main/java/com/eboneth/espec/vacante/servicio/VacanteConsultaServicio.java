package com.eboneth.espec.vacante.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eboneth.espec.infraestructura.core.busqueda.BusquedaServicio;
import com.eboneth.espec.infraestructura.core.crud.OperacionCrudImplementacion;
import com.eboneth.espec.vacante.dto.VacanteDtoConsulta;
import com.eboneth.espec.vacante.entidad.Vacante;
import com.eboneth.espec.vacante.repositorio.VacanteRepositorio;
import com.eboneth.espec.vacante.utilidad.mapeador.VacanteMapperNativo;
import com.eboneth.espec.vacante.utilidad.querBuilder.SqlBuilderVacante;

import jakarta.persistence.Query;
import jakarta.persistence.Tuple;


@Service
public class VacanteConsultaServicio extends OperacionCrudImplementacion<Vacante, Integer> {

    @Value("${especializacion.url.base-imagenes}")
    private String baseUrlImagenes;

    private final VacanteRepositorio vacanteRepositorio;
    private final VacanteMapperNativo vacanteMapperNativo;
    
    public VacanteConsultaServicio(BusquedaServicio<Vacante, Integer> servicioBuscarVacante,
            VacanteRepositorio vacanteRepositorio, VacanteMapperNativo vacanteMapperNativo) {
        super(servicioBuscarVacante);
        this.vacanteRepositorio = vacanteRepositorio;
        this.vacanteMapperNativo = vacanteMapperNativo;
    }

    @Override
    protected JpaRepository<Vacante, Integer> getRepositorio() {
        return vacanteRepositorio;
    }

    @Transactional(readOnly = true)
    public List<VacanteDtoConsulta> consultaVacante(String campoOrden, String tipoOrden){
        String campoOrdenNormalizado = (tipoOrden != null && !campoOrden.isBlank())
        ? campoOrden
        : "v.fecha_inicio_vacante";

        String tipoOrdenNormalizado = (tipoOrden != null && tipoOrden.equalsIgnoreCase("ASC"))
        ? "ASC" : "DESC";

        String sql = SqlBuilderVacante.consulta(campoOrdenNormalizado, tipoOrdenNormalizado);
        Query consulta = entityManager.createNativeQuery(sql, Tuple.class);

        List<Tuple> resultados = consulta.getResultList();

        return resultados.stream().map(tupla -> {
            VacanteDtoConsulta dtoConsulta = vacanteMapperNativo.mapearDesdeTupla(tupla);
            String url = baseUrlImagenes + "/" + dtoConsulta.getNombrePrivadoAnuncio();
            return dtoConsulta.conImagenUrl(url);
        }).toList();
    }

    


    
    
}
