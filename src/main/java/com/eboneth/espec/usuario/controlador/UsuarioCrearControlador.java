package com.eboneth.espec.usuario.controlador;

import com.eboneth.espec.infraestructura.dto.ArchivoDtoMetadato;
import com.eboneth.espec.infraestructura.utilidad.respuesta.RespuestaHttp;
import com.eboneth.espec.infraestructura.utilidad.validacion.ArchivoRegla;
import com.eboneth.espec.usuario.dto.ImagenDtoMetadato;
import com.eboneth.espec.usuario.dto.UsuarioDtoCrear;
import com.eboneth.espec.usuario.dto.UsuarioDtoRespuesta;
import com.eboneth.espec.usuario.servicio.UsuarioCrearServicio;
import com.eboneth.espec.vacante.dto.AnuncionDtoMetadato;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UsuarioCrearControlador {

    private final UsuarioCrearServicio usuarioCrearServicio;
    private static  final long TAMANIO_ARCHIVO = 1024 * 1024 * 5;
    private static  final List<String> TIPO_ARCHIVO_PERMITIDO = List.of(
            "image/jpeg",
            "image/png",
            "image/jpg"
    );

    public UsuarioCrearControlador(UsuarioCrearServicio usuarioCrearServicio) {
        this.usuarioCrearServicio = usuarioCrearServicio;
    }

    @PostMapping("/add")
    public ResponseEntity<?> nuevoUsuario (@ModelAttribute UsuarioDtoCrear usuarioDtoCrear) {

        MultipartFile archivo = usuarioDtoCrear.getArchivo();
        ArchivoRegla.verificar(archivo, TIPO_ARCHIVO_PERMITIDO, TAMANIO_ARCHIVO);
        ArchivoDtoMetadato metadato = ArchivoRegla.extraerMetadatos(archivo);

        ImagenDtoMetadato imagenDtoMetadato = new ImagenDtoMetadato(
                metadato.getNombrePublico(),
                metadato.getTamanio(),
                metadato.getTipoMIME(),
                metadato.getNombrePrivado()
                );

        UsuarioDtoRespuesta usuarioDtoRespuesta = usuarioCrearServicio.CrearUsuario(usuarioDtoCrear, imagenDtoMetadato);
        return RespuestaHttp.ok("Usuario creado correctamente", usuarioDtoRespuesta);
    }
}
