package com.eboneth.espec.vacante.entidad;

import com.eboneth.espec.vacante.entidad.pk.InteresesPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Table(name = "intereses")
@Entity(name = "vacante_Intereses")
public class Interes implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected InteresesPK interesesPK;

    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;

    @Column(name = "tipo_interes", nullable = false)
    private short tipoInteres;

    public Interes() {
    }

    public Interes(InteresesPK interesesPK) {
        this.interesesPK = interesesPK;
    }

    public Interes(InteresesPK interesesPK, short tipoInteres) {
        this.interesesPK = interesesPK;
        this.tipoInteres = tipoInteres;
    }

    public Interes(int idEmpresa, int idUsuario) {
        this.interesesPK = new InteresesPK(idEmpresa, idUsuario);
    }

    public InteresesPK getInteresesPK() {
        return interesesPK;
    }

    public void setInteresesPK(InteresesPK interesesPK) {
        this.interesesPK = interesesPK;
    }

    public short getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(short tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresas) {
        this.empresa = empresas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuarios) {
        this.usuario = usuarios;
    }

    @Override
    public int hashCode() {
        return Objects.hash(interesesPK);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Interes other = (Interes) obj;
        return Objects.equals(interesesPK, other.interesesPK);
    }

    @Override
    public String toString() {
        return "empresaId=" + (interesesPK != null ? interesesPK.getIdEmpresa() : null)
                + ", usuarioId=" + (interesesPK != null ? interesesPK.getIdUsuario() : null)
                + ", tipoInteres=" + tipoInteres;
    }
}
