package com.eboneth.espec.usuario.dto;

import org.springframework.web.multipart.MultipartFile;

public class UsuarioDtoCrear {

    private short tipoDocumentoUsuario;
    private String documentoUsuario;
    private String nombreUsuario;
    private String apellidosUsuario;
    private Short estadoUsuario;
    private Integer idUbicacion;
    private MultipartFile archivo;
    public UsuarioDtoCrear() {
    }

    public UsuarioDtoCrear(
            short tipoDocumentoUsuario,
            String documentoUsuario,
            String nombreUsuario,
            String apellidosUsuario,
            Short estadoUsuario,
            Integer idUbicacion,
            Integer idUsuario,
            MultipartFile archivo) {
        this.tipoDocumentoUsuario = tipoDocumentoUsuario;
        this.documentoUsuario = documentoUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.estadoUsuario = estadoUsuario;
        this.idUbicacion = idUbicacion;
        this.archivo = archivo;
    }

    public short getTipoDocumentoUsuario() {
        return tipoDocumentoUsuario;
    }

    public void setTipoDocumentoUsuario(short tipoDocumentoUsuario) {
        this.tipoDocumentoUsuario = tipoDocumentoUsuario;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(String documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public Short getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Short estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Integer getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Integer idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public MultipartFile getArchivo() {
        return archivo;
    }

    @Override
    public String toString() {
        return "UsuarioDtoCrear{" +
                "tipoDocumentoUsuario='" + tipoDocumentoUsuario +
                "documentoUsuario='" + documentoUsuario +
                "nombreUsuario='" + nombreUsuario +
                "apellidosUsuario='" + apellidosUsuario +
                "estadoUsuario=" + estadoUsuario +
                "idUbicacion=" + idUbicacion +
                "archivo=" + archivo +
                '}';
    }

    public void setArchivo(MultipartFile archivo) {
        this.archivo = archivo;
    }
}
