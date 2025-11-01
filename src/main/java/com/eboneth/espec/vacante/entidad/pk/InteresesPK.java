package com.eboneth.espec.vacante.entidad.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class InteresesPK implements Serializable {

    @NotNull
    @Column(name = "id_empresa", nullable = false)
    private Integer idEmpresa;

    @NotNull
    @Column(name = "id_usuario", nullable = false)
    private Integer idUsuario;

    public InteresesPK() {
    }

    public InteresesPK(int idEmpresa, int idUsuario) {
        this.idEmpresa = idEmpresa;
        this.idUsuario = idUsuario;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpresa, idUsuario);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        InteresesPK other = (InteresesPK) obj;
        return Objects.equals(idEmpresa, other.idEmpresa)
                && Objects.equals(idUsuario, other.idUsuario);
    }

    @Override
    public String toString() {
        return "idEmpresa=" + idEmpresa + ", idUsuario=" + idUsuario;
    }

}
