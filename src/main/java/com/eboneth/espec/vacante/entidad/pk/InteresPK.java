package com.eboneth.espec.vacante.entidad.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InteresPK implements Serializable {

    @NotNull
    @Column(name = "id_empresa", nullable = false)
    private Integer idEmpresa;

    @NotNull
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    public InteresPK() {
    }

    public InteresPK(Integer idEmpresa, Integer idUsuario) {
        this.idEmpresa = idEmpresa;
        this.idUsuario = idUsuario;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof InteresPK interesPK)) return false;
        return Objects.equals(idEmpresa, interesPK.idEmpresa) && Objects.equals(idUsuario, interesPK.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpresa, idUsuario);
    }

    @Override
    public String toString() {
        return "InteresPK{" +
                "idEmpresa=" + idEmpresa +
                "idUsuario=" + idUsuario +
                '}';
    }
}
