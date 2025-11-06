package com.eboneth.espec.usuario.servicio;

import com.eboneth.espec.infraestructura.constante.ConstanteTipoArchivo;
import com.eboneth.espec.infraestructura.core.busqueda.BusquedaServicio;
import com.eboneth.espec.infraestructura.core.crud.OperacionCrudImplementacion;
import com.eboneth.espec.infraestructura.excepcion.ExcepcionNegocio;
import com.eboneth.espec.infraestructura.utilidad.archivo.GestorArchivoAdmin;
import com.eboneth.espec.infraestructura.utilidad.archivo.GestorArchivoInstancia;

import com.eboneth.espec.usuario.dto.ImagenDtoMetadato;
import com.eboneth.espec.usuario.dto.UsuarioDtoCrear;
import com.eboneth.espec.usuario.dto.UsuarioDtoRespuesta;
import com.eboneth.espec.usuario.entidad.Imagen;
import com.eboneth.espec.usuario.entidad.Usuario;
import com.eboneth.espec.usuario.repositorio.ImagenRepositorio;
import com.eboneth.espec.usuario.repositorio.UbicacionRepositorio;
import com.eboneth.espec.usuario.repositorio.UsuarioRepositorio;
import com.eboneth.espec.usuario.utilidad.mapeador.UsuarioMapper;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UsuarioCrearServicio extends OperacionCrudImplementacion <Usuario, Integer>{

    private final UsuarioRepositorio usuarioRepositorio;
    private final ImagenRepositorio imagenRepositorio;
    private final UbicacionRepositorio ubicacionRepositorio;
    private final UsuarioMapper usuarioMapper;
    private final GestorArchivoAdmin gestorArchivoAdmin;

    public UsuarioCrearServicio(BusquedaServicio<Usuario, Integer> usuarioBuscar,
                                UsuarioRepositorio usuarioRepositorio,
                                ImagenRepositorio imagenRepositorio,
                                UbicacionRepositorio ubicacionRepositorio,
                                GestorArchivoAdmin gestorArchivoAdmin, UsuarioMapper usuarioMapper) {
        super(usuarioBuscar);
        this.usuarioRepositorio = usuarioRepositorio;
        this.imagenRepositorio = imagenRepositorio;
        this.ubicacionRepositorio = ubicacionRepositorio;
        this.usuarioMapper = usuarioMapper;
        this.gestorArchivoAdmin = gestorArchivoAdmin;
    }

    @Override
    protected JpaRepository<Usuario, Integer> getRepositorio() {
       return usuarioRepositorio;
    }

    @Transactional
    public UsuarioDtoRespuesta CrearUsuario(UsuarioDtoCrear usuarioDtoCrear,
                                            ImagenDtoMetadato imagenDtoMetadato) {
        Usuario usuario = usuarioMapper.desdeDto(usuarioDtoCrear);
        usuario = usuarioRepositorio.save(usuario);
        crearImagen(usuario, imagenDtoMetadato);

        guardarImagenServidor(usuarioDtoCrear.getArchivo(), imagenDtoMetadato);

        return usuarioMapper.desdeEntidad(usuario);

    }

    private void guardarImagenServidor(MultipartFile archivo, ImagenDtoMetadato imagenDtoMetadato) {
        GestorArchivoInstancia instancia = gestorArchivoAdmin.crear(
                ConstanteTipoArchivo.IMAGEN,
                imagenDtoMetadato.getNombrePrivadoImagen(),
                null,
                archivo
        );

        boolean exito = instancia.guardar();
        if (!exito) {
            throw new ExcepcionNegocio("No se pudo guardar el imagen");
        }

    }

    private void crearImagen(Usuario usuario, ImagenDtoMetadato imagenDtoMetadato) {
        Imagen imagen = new Imagen();
        imagen.setIdUsuario(usuario);
        imagen.setNombrePublicoImagen(imagenDtoMetadato.getNombrePublicoImagen());
        imagen.setNombrePrivadoImagen(imagenDtoMetadato.getNombrePrivadoImagen());
        imagen.setTipoImagen(imagenDtoMetadato.getTipoImagen());
        imagen.setTamanioImagen(imagenDtoMetadato.getTamanioImagen());

        imagenRepositorio.save(imagen);
    }
}
