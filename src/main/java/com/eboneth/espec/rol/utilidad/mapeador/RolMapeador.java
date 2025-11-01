
package com.eboneth.espec.rol.utilidad.mapeador;

import com.eboneth.espec.rol.entidad.Rol;
import com.eboneth.espec.rol.dto.RolDtoRespuesta;
import com.eboneth.espec.infraestructura.utilidad.mapeador.MapeoEntidadDto;
import org.springframework.stereotype.Component;

@Component
public class RolMapeador implements MapeoEntidadDto<Rol, RolDtoRespuesta>{
    
    @Override
    public RolDtoRespuesta desdeEntidad(Rol rol) {
        if (rol == null) {
            return null;
        }
        return new RolDtoRespuesta(rol.getIdRol(), rol.getNombreRol(), rol.getEstadoRol());
    }

    @Override
    public Rol desdeDto(RolDtoRespuesta dto) {
        if (dto == null) {
            return null;
        }
        
        Rol rol = new Rol();
        rol.setIdRol(dto.idRol());
        rol.setNombreRol(dto.nombreRol());
        rol.setEstadoRol(dto.estadoRol());
        
        return rol;
    }

}
