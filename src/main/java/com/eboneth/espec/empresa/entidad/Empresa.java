package com.eboneth.espec.empresa.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "empresas")
@Entity(name = "empresa_Empresa")
public class Empresa implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empresa", nullable = false)
    private Integer idEmpresa;
    
    @NotNull
    @Column(name = "nombre_empresa", nullable = false, unique = true, length = 200)
    private String nombreEmpresa;
   
    @Column(name = "direccion_empresa", nullable = false, unique = true, length = 200)
    private String direccionEmpresa;
    
    @Column(name = "telefono_empresa", nullable = false, unique = true, length = 200)
    private String telefonoEmpresa;
    
    @NotNull
    @JoinColumn(name = "id_tipo_empresa", referencedColumnName = "id_tipo_empresa")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoEmpresa idTipoEmpresa;

    public Empresa() {
    }

    public Empresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa(Integer idEmpresa, String nombreEmpresa, String direccionEmpresa, String telefonoEmpresa, TipoEmpresa idTipoEmpresa) {
        this.idEmpresa = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public TipoEmpresa getIdTipoEmpresa() {
        return idTipoEmpresa;
    }

    public void setIdTipoEmpresa(TipoEmpresa idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.idEmpresa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empresa other = (Empresa) obj;
        return Objects.equals(this.idEmpresa, other.idEmpresa);
    }

    @Override
    public String toString() {
        return "idEmpresa=" + idEmpresa 
                + ", nombreEmpresa=" + nombreEmpresa 
                + ", direccionEmpresa=" + direccionEmpresa 
                + ", telefonoEmpresa=" + telefonoEmpresa 
                + ", idTipoEmpresa=" + (idTipoEmpresa != null ? idTipoEmpresa.getNombreTipoEmpresa(): null);
    }
    
    
}
