package com.eboneth.espec.vacante.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

@Table(name = "palabras_claves")
@Entity(name = "vacantes_PalabraClaves")
public class PalabraClave implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_palabra_clave")
    private Integer idPalabraClave;

    @NotNull
    @JoinColumn(name = "id_area", referencedColumnName = "id_area")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Area idArea;

    @NotNull
    @Size(min=1, max=150)
    @Column(name = "texto_palabra_clave", nullable = false, unique = true, length = 150)
    private  String textoPalabraClave;

    public PalabraClave() {
    }

    public PalabraClave(Integer idPalabraClave) {
        this.idPalabraClave = idPalabraClave;
    }

    public PalabraClave(Integer idPalabraClave, Area idArea, String textoPalabraClave) {
        this.idPalabraClave = idPalabraClave;
        this.idArea = idArea;
        this.textoPalabraClave = textoPalabraClave;
    }

    public Integer getIdPalabraClave() {
        return idPalabraClave;
    }

    public void setIdPalabraClave(Integer idPalabraClave) {
        this.idPalabraClave = idPalabraClave;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    public String getTextoPalabraClave() {
        return textoPalabraClave;
    }

    public void setTextoPalabraClave(String textoPalabraClave) {
        this.textoPalabraClave = textoPalabraClave;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof PalabraClave that)) return false;
        return Objects.equals(idPalabraClave, that.idPalabraClave);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPalabraClave);
    }

    @Override
    public String toString() {
        return "PalabraClave{" +
                "idPalabraClave=" + idPalabraClave +
                "idArea=" + idArea +
                "textoPalabraClave='" + textoPalabraClave + '\'' +
                '}';
    }
}
