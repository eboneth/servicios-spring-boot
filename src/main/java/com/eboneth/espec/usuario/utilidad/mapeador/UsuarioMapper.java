package com.eboneth.espec.usuario.utilidad.mapeador;

import com.eboneth.espec.infraestructura.utilidad.mapeador.MapeoEntidadDto;
import com.eboneth.espec.usuario.dto.UsuarioDtoCrear;
import com.eboneth.espec.usuario.dto.UsuarioDtoRespuesta;
import com.eboneth.espec.usuario.entidad.*;
import com.eboneth.espec.usuario.entidad.Ubicacion;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper implements MapeoEntidadDto<Usuario, UsuarioDtoRespuesta> {

    @Override
    public UsuarioDtoRespuesta desdeEntidad(Usuario usuario) {
        if (usuario == null) {
            return null;
        }

        UsuarioDtoRespuesta dtoRespuesta = new UsuarioDtoRespuesta();
        dtoRespuesta.setIdUsuario(usuario.getIdUsuario());
        dtoRespuesta.setNombresUsuario(usuario.getNombresUsuario());
        return dtoRespuesta;
    }

    @Override
    public Usuario desdeDto(UsuarioDtoRespuesta dto) {
        if (dto == null) {
            return null;
        }
        Usuario dtoUsuario = new Usuario();
        dtoUsuario.setIdUsuario(dto.getIdUsuario());
        dtoUsuario.setNombresUsuario(dto.getNombresUsuario());
        return dtoUsuario;
    }

    public Usuario desdeDto(UsuarioDtoCrear dto, Object... objetosExternos) {

        if (dto == null) {
            return null;
        }

        Usuario dtoUsuario = new Usuario();
        dtoUsuario.setNombresUsuario(dto.getNombreUsuario());
        dtoUsuario.setApellidosUsuario(dto.getApellidosUsuario());
        dtoUsuario.setDocumentoUsuario(dto.getDocumentoUsuario());
        dtoUsuario.setTipoDocumentoUsuario(dto.getTipoDocumentoUsuario());
        dtoUsuario.setEstadoUsuario(dto.getEstadoUsuario());

        if(dto.getIdUbicacion() != null){
            Ubicacion ubicacion = new Ubicacion();
            ubicacion.setIdUbicacion(dto.getIdUbicacion());
            dtoUsuario.setIdUbicacion(ubicacion);
        }

        return dtoUsuario;
    }
}
