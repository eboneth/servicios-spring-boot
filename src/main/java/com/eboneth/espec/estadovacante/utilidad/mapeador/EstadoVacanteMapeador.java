package com.eboneth.espec.estadovacante.utilidad.mapeador;

import com.eboneth.espec.estadovacante.dto.EstadoVacanteDtoRespuesta;
import com.eboneth.espec.estadovacante.entidad.EstadoVacante;
import com.eboneth.espec.infraestructura.utilidad.mapeador.MapeoEntidadDto;
import org.springframework.stereotype.Component;

@Component
public class EstadoVacanteMapeador implements MapeoEntidadDto<EstadoVacante, EstadoVacanteDtoRespuesta> {

    @Override
    public EstadoVacanteDtoRespuesta desdeEntidad(EstadoVacante myEntity) {
        if(myEntity == null) {
            return null;
        }
        return new EstadoVacanteDtoRespuesta(
                myEntity.getIdEstadoVacante(),
                myEntity.getNombreEstadoVacante(),
                myEntity.getOrdenEstadoVacante());
    }

    @Override
    public EstadoVacante desdeDto(EstadoVacanteDtoRespuesta myDto) {
        if(myDto == null) {
            return null;
        }
        EstadoVacante entidad = new EstadoVacante();
        entidad.setIdEstadoVacante(myDto.idEstadoVacante());
        entidad.setNombreEstadoVacante(myDto.nombreEstadoVacante());
        entidad.setOrdenEstadoVacante(myDto.ordenEstadoVacante());
        return entidad;
    }
}
