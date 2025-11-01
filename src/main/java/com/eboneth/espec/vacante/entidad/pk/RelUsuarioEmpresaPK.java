package com.eboneth.espec.vacante.entidad.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RelUsuarioEmpresaPK implements Serializable {

    @NotNull
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    @NotNull
    @Column(name = "id_empresa", nullable = false)
    private Integer idEmpresa;

    public RelUsuarioEmpresaPK() {
    }

    public RelUsuarioEmpresaPK(int idUsuario, int idEmpresa) {
        this.idUsuario = idUsuario;
        this.idEmpresa = idEmpresa;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idEmpresa);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RelUsuarioEmpresaPK other = (RelUsuarioEmpresaPK) obj;
        return Objects.equals(idUsuario, other.idUsuario)
                && Objects.equals(idEmpresa, other.idEmpresa);
    }

    @Override
    public String toString() {
        return "idUsuario=" + idUsuario + ", idEmpresa=" + idEmpresa;
    }

}
