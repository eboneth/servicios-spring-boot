package com.eboneth.espec.usuario.dto;

public class UsuarioDtoRespuesta {
    private Integer idUsuario;
    private String nombresUsuario;

    public UsuarioDtoRespuesta() {
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombresUsuario() {
        return nombresUsuario;
    }

    public void setNombresUsuario(String nombresUsuario) {
        this.nombresUsuario = nombresUsuario;
    }
}
