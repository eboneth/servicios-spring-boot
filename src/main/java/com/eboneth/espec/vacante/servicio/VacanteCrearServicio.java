package com.eboneth.espec.vacante.servicio;

import com.eboneth.espec.infraestructura.core.busqueda.BusquedaServicio;
import com.eboneth.espec.infraestructura.core.crud.OperacionCrudImplementacion;
import com.eboneth.espec.vacante.dto.AnuncionDtoMetadato;
import com.eboneth.espec.vacante.dto.VacanteDtoCrear;
import com.eboneth.espec.vacante.dto.VacanteDtoRespuesta;
import com.eboneth.espec.vacante.entidad.Vacante;
import com.eboneth.espec.vacante.repositorio.*;
import com.eboneth.espec.vacante.utilidad.mapeador.VacanteMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class VacanteCrearServicio extends OperacionCrudImplementacion <Vacante, Integer>{

    private final VacanteRepositorio vacanteRepositorio;
    private final RelVacantePalabraClaveRepositorio relVacantePalabraClaveRepositorio;
    private final AnuncioRepositorio anuncioRepositorio;
    private final HistorialEstadoVacanteRepositorio historialEstadoVacanteRepositorio;
    private final EstadoVacanteRepositorio estadoVacanteRepositorio;
    private final VacanteMapper vacanteMapper;

    public VacanteCrearServicio(BusquedaServicio<Vacante, Integer> servicioBuscar,
                                VacanteRepositorio vacanteRepositorio,
                                RelVacantePalabraClaveRepositorio relVacantePalabraClaveRepositorio,
                                AnuncioRepositorio anuncioRepositorio,
                                HistorialEstadoVacanteRepositorio historialEstadoVacanteRepositorio,
                                EstadoVacanteRepositorio estadoVacanteRepositorio,
                                VacanteMapper vacanteMapper) {
        super(servicioBuscar);
        this.vacanteRepositorio = vacanteRepositorio;
        this.relVacantePalabraClaveRepositorio = relVacantePalabraClaveRepositorio;
        this.anuncioRepositorio = anuncioRepositorio;
        this.historialEstadoVacanteRepositorio = historialEstadoVacanteRepositorio;
        this.estadoVacanteRepositorio = estadoVacanteRepositorio;
        this.vacanteMapper = vacanteMapper;
    }

    @Override
    protected JpaRepository<Vacante, Integer> getRepositorio() {
       return vacanteRepositorio;
    }

    public VacanteDtoRespuesta CrearVacante(VacanteDtoCrear dtoVacante,
                                            AnuncionDtoMetadato anuncionDtoMetadato) {
        Vacante vacante = vacanteMapper.desdeDto(dtoVacante);




        return vacanteMapper.desdeEntidad(vacante);

    }
}
