package com.eboneth.espec.vacante.entidad;

import com.eboneth.espec.vacante.entidad.pk.InteresPK;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;

@Table(name="intereses",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_usuario", "id_empresa"}))
@Entity(name ="vacante_Interes")
public class Interes implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected InteresPK interesPK;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario;

    @JoinColumn(name = "id_empresa", referencedColumnName = "id_empresa", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;

    @NotNull
    @Column(name = "tipo_interes")
    private Short tipoInteres;

    public Interes() {
    }

    public Interes(InteresPK interesPK, Short tipoInteres) {
        this.interesPK = interesPK;
        this.tipoInteres = tipoInteres;
    }

    public Interes(InteresPK interesPK, Usuario usuario, Empresa empresa, Short tipoInteres) {
        this.interesPK = interesPK;
        this.usuario = usuario;
        this.empresa = empresa;
        this.tipoInteres = tipoInteres;
    }

    public InteresPK getInteresPK() {
        return interesPK;
    }

    public void setInteresPK(InteresPK interesPK) {
        this.interesPK = interesPK;
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

    public Short getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(Short tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Interes interes)) return false;
        return Objects.equals(interesPK, interes.interesPK);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(interesPK);
    }

    @Override
    public String toString() {
        return "Interes{" +
                "interesPK=" + interesPK +
                "usuario=" + usuario +
                "empresa=" + empresa +
                "tipoInteres=" + tipoInteres +
                '}';
    }
}
