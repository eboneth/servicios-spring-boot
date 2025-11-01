package com.eboneth.espec.vacante.utilidad.mapeador;

import com.eboneth.espec.infraestructura.utilidad.mapeador.MapeoEntidadDto;
import com.eboneth.espec.vacante.dto.VacanteDtoCrear;
import com.eboneth.espec.vacante.dto.VacanteDtoRespuesta;
import com.eboneth.espec.vacante.entidad.*;
import com.eboneth.espec.vacante.entidad.pk.RelUsuarioEmpresaPK;
import org.springframework.stereotype.Component;

@Component
public class VacanteMapper implements MapeoEntidadDto<Vacante, VacanteDtoRespuesta> {

    @Override
    public VacanteDtoRespuesta desdeEntidad(Vacante entidad) {
        if (entidad == null) {
            return null;
        }

        VacanteDtoRespuesta dtoRespuesta = new VacanteDtoRespuesta();
        dtoRespuesta.setIdVacante(entidad.getIdVacante());
        dtoRespuesta.setTituloVacante(entidad.getTituloVacante());
        return dtoRespuesta;
    }

    @Override
    public Vacante desdeDto(VacanteDtoRespuesta dto) {
        if (dto == null) {
            return null;
        }
        Vacante dtoVacante = new Vacante();
        dtoVacante.setIdVacante(dto.getIdVacante());
        dtoVacante.setTituloVacante(dto.getTituloVacante());
        return dtoVacante;
    }

    public Vacante desdeDto(VacanteDtoCrear dto, Object... objetosExternos) {

        if (dto == null) {
            return null;
        }

        Vacante dtoEntidad = new Vacante();
        dtoEntidad.setTituloVacante(dto.getTituloVacante());
        dtoEntidad.setDetalleVacante(dto.getDetalleVacante());
        dtoEntidad.setFechaInicioVacante(dto.getFechaInicioVacante());
        dtoEntidad.setFechaFinVacante(dto.getFechaFinVacante());
        dtoEntidad.setEstadoVacante(dto.getEstadoVacante());
        dtoEntidad.setMinSalarioVacante(dto.getMinSalarioVacante());
        dtoEntidad.setMaxSalarioVacante(dto.getMaxSalarioVacante());

        if(dto.getIdUbicacion() != null){
            Ubicacion ubicacion = new Ubicacion();
            ubicacion.setIdUbicacion(dto.getIdUbicacion());
            dtoEntidad.setIdUbicacion(ubicacion);
        }

        if(dto.getIdEmpresa() != null || dto.getIdUsuario() != null){
            Short permisionRelUsuarioEmpresa = 1;
            RelUsuarioEmpresa relUsuarioEmpresa = new RelUsuarioEmpresa();
            RelUsuarioEmpresaPK relUsuarioEmpresaPK = new RelUsuarioEmpresaPK(dto.getIdUsuario(), dto.getIdEmpresa());
            relUsuarioEmpresa.setRelUsuarioEmpresaPK(relUsuarioEmpresaPK);
            relUsuarioEmpresa.setPermisoRelUsuarioEmpresa(permisionRelUsuarioEmpresa);
            dtoEntidad.setRelUsuariosEmpresas(relUsuarioEmpresa);
        }

        if(dto.getIdJornada() != null){
            Jornada jornada = new Jornada();
            jornada.setIdJornada(dto.getIdJornada());
            dtoEntidad.setIdJornada(jornada);
        }

        if(dto.getIdModalidad() != null){
            Modalidad modalidad = new Modalidad();
            modalidad.setIdModalidad(dto.getIdModalidad());
            dtoEntidad.setIdModalidad(modalidad);
        }

        if(dto.getIdTipoContrato() != null){
            TipoContrato tipoContrato = new TipoContrato();
            tipoContrato.setIdTipoContrato(dto.getIdJornada());
            dtoEntidad.setIdTipoContrato(tipoContrato);
        }

        return dtoEntidad;
    }
}
