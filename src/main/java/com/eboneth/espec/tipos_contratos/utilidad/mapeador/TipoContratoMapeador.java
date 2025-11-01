package com.eboneth.espec.tipos_contratos.utilidad.mapeador;

import com.eboneth.espec.infraestructura.utilidad.mapeador.MapeoEntidadDto;
import com.eboneth.espec.tipos_contratos.entity.TipoContrato;
import com.eboneth.espec.tipos_contratos.dto.TipoContratoDtoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class TipoContratoMapeador implements MapeoEntidadDto<TipoContrato, TipoContratoDtoRespuesta>{
    @Override
    public TipoContratoDtoRespuesta desdeEntidad(TipoContrato myEntity) {
        if(myEntity == null) {
            return null;
        }
        return new TipoContratoDtoRespuesta(
                myEntity.getIdTipoContrato(),
                myEntity.getNombreTipoContrato());
    }
    
    @Override
    public TipoContrato desdeDto(TipoContratoDtoRespuesta myDto) {
        if(myDto == null) {
            return null;
        }
        TipoContrato entidad = new TipoContrato();
        entidad.setIdTipoContrato(myDto.idTipoContrato());
        entidad.setNombreTipoContrato(myDto.nombreTipoContrato());

        return entidad;
    }
}
