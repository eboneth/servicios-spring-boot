
package com.eboneth.espec.empresa.utilidad.mapeador;

import com.eboneth.espec.empresa.dto.TipoEmpresaDtoRespuesta;
import com.eboneth.espec.empresa.entidad.TipoEmpresa;
import com.eboneth.espec.utilidad.mapeador.MapeoEntidadDto;
import org.springframework.stereotype.Component;

@Component
public class TipoEmpresaMapeador implements MapeoEntidadDto<TipoEmpresa, TipoEmpresaDtoRespuesta>{

    @Override
    public TipoEmpresaDtoRespuesta desdeEntidad(TipoEmpresa entidad) {
        if (entidad == null) {
            return null;
        }
        return new TipoEmpresaDtoRespuesta(entidad.getIdTipoEmpresa(), entidad.getNombreTipoEmpresa(), entidad.getEstadoTipoEmpresa());
    }

    @Override
    public TipoEmpresa desdeDto(TipoEmpresaDtoRespuesta dto) {
        if (dto == null) {
            return null;
        }
        
        TipoEmpresa entidad = new TipoEmpresa();
        entidad.setIdTipoEmpresa(dto.idTipoEmpresa());
        entidad.setNombreTipoEmpresa(dto.nombreTipoEmpresa());
        entidad.setEstadoTipoEmpresa(dto.estadoTipoEmpresa());
        
        return entidad;
    }
    
    
}
