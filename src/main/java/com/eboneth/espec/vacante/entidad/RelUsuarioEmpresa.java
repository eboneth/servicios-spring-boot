package com.eboneth.espec.vacante.entidad;

import com.eboneth.espec.vacante.entidad.pk.RelUsuarioEmpresaPK;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Table(name="rel_usuarios_empresas",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_usuario", "id_empresa"}))
@Entity(name = "vacantes_RelUsuarioEmpresa")
public class RelUsuarioEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected RelUsuarioEmpresaPK relUsuarioEmpresaPK;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Empresa empresa;

    @NotNull
    @Column(name = "permiso_rel_usuario_empresa")
    private Short permisoRelUsuarioEmpresa;

    public RelUsuarioEmpresa() {
    }

    public RelUsuarioEmpresa(RelUsuarioEmpresaPK relUsuarioEmpresaPK, Short permisoRelUsuarioEmpresa) {
        this.relUsuarioEmpresaPK = relUsuarioEmpresaPK;
        this.permisoRelUsuarioEmpresa = permisoRelUsuarioEmpresa;
    }

    public RelUsuarioEmpresa(RelUsuarioEmpresaPK relUsuarioEmpresaPK) {
        this.relUsuarioEmpresaPK = relUsuarioEmpresaPK;
    }

    public RelUsuarioEmpresa(int idUsuario, int idEmpresa) {
        this.relUsuarioEmpresaPK = new RelUsuarioEmpresaPK(idUsuario, idEmpresa);
    }

    public RelUsuarioEmpresaPK getRelUsuarioEmpresaPK() {
        return relUsuarioEmpresaPK;
    }

    public void setRelUsuarioEmpresaPK(RelUsuarioEmpresaPK relUsuarioEmpresaPK) {
        this.relUsuarioEmpresaPK = relUsuarioEmpresaPK;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Short getPermisoRelUsuarioEmpresa() {
        return permisoRelUsuarioEmpresa;
    }

    public void setPermisoRelUsuarioEmpresa(Short permisoRelUsuarioEmpresa) {
        this.permisoRelUsuarioEmpresa = permisoRelUsuarioEmpresa;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RelUsuarioEmpresa that)) return false;
        return Objects.equals(relUsuarioEmpresaPK, that.relUsuarioEmpresaPK);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(relUsuarioEmpresaPK);
    }

    @Override
    public String toString() {
        return "RelUsuarioEmpresa{" +
                "relUsuarioEmpresaPK=" + relUsuarioEmpresaPK +
                "usuario=" + usuario +
                "empresa=" + empresa +
                "permisoRelUsuarioEmpresa=" + permisoRelUsuarioEmpresa +
                '}';
    }
}
