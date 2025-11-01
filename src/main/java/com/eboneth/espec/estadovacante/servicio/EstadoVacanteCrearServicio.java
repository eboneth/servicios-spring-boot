package com.eboneth.espec.estadovacante.servicio;

import com.eboneth.espec.infraestructura.core.crud.OperacionCrudImplementacion;
import com.eboneth.espec.infraestructura.core.busqueda.BusquedaServicio;
import com.eboneth.espec.estadovacante.dto.EstadoVacanteDtoCrear;
import com.eboneth.espec.estadovacante.dto.EstadoVacanteDtoRespuesta;
import com.eboneth.espec.estadovacante.entidad.EstadoVacante;
import com.eboneth.espec.estadovacante.repositorio.EstadoVacanteRepositorio;
import com.eboneth.espec.estadovacante.utilidad.mapeador.EstadoVacanteMapeador;
import com.eboneth.espec.estadovacante.utilidad.validacion.EstadoVacanteValidacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class EstadoVacanteCrearServicio extends OperacionCrudImplementacion<EstadoVacante, Integer> {
    private final EstadoVacanteRepositorio estadoVacanteRepositorio;
    private final EstadoVacanteMapeador estadoVacanteMapeador;

    public EstadoVacanteCrearServicio(
            EstadoVacanteRepositorio estadoVacanteRepositorio,
            EstadoVacanteMapeador estadoVacanteMapeador,
            BusquedaServicio<EstadoVacante, Integer> searchService) {
        super(searchService);
        this.estadoVacanteRepositorio = estadoVacanteRepositorio;
        this.estadoVacanteMapeador = estadoVacanteMapeador;
    }

    @Override
    protected JpaRepository<EstadoVacante, Integer> getRepositorio() {
        return estadoVacanteRepositorio;
    }

    public EstadoVacanteDtoRespuesta crearEstadoVacante(EstadoVacanteDtoCrear dto) {
        String nombreSinEspacios = dto.nombreEstadoVacante().trim();
        Short orden = EstadoVacanteValidacion.ordenAjustado(dto.ordenEstadoVacante());
        EstadoVacanteValidacion.validarNombre(nombreSinEspacios);
        EstadoVacante objetoNuevo = new EstadoVacante();
        objetoNuevo.setNombreEstadoVacante(nombreSinEspacios);
        objetoNuevo.setOrdenEstadoVacante(orden);
        EstadoVacante registrada = agregar(objetoNuevo);
        return estadoVacanteMapeador.desdeEntidad(registrada);
    }
}
