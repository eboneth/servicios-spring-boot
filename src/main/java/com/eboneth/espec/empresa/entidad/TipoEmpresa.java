
package com.eboneth.espec.empresa.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "tipo_empresas", indexes = @Index(name = "idx_nombre_tipo_empresa", columnList= "nombre_tipo_empresa"))
@Entity(name = "empresa_TipoEmpresa")
public class TipoEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_empresa", nullable = false)
    private Integer idTipoEmpresa;
    
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_tipo_empresa", nullable = false, unique = true, length = 150)
    private String nombreTipoEmpresa;
    
    @NotNull
    @Column(name = "estado_tipo_empresa", nullable = false)
    private Short estadoTipoEmpresa; 

    public TipoEmpresa() {
        
    }

    public TipoEmpresa(Integer idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public TipoEmpresa(Integer idTipoEmpresa, String nombreTipoEmpresa, Short estadoTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
        this.nombreTipoEmpresa = nombreTipoEmpresa;
        this.estadoTipoEmpresa = estadoTipoEmpresa;
    }

    public Integer getIdTipoEmpresa() {
        return idTipoEmpresa;
    }

    public void setIdTipoEmpresa(Integer idTipoEmpresa) {
        this.idTipoEmpresa = idTipoEmpresa;
    }

    public String getNombreTipoEmpresa() {
        return nombreTipoEmpresa;
    }

    public void setNombreTipoEmpresa(String nombreTipoEmpresa) {
        this.nombreTipoEmpresa = nombreTipoEmpresa;
    }

    public Short getEstadoTipoEmpresa() {
        return estadoTipoEmpresa;
    }

    public void setEstadoTipoEmpresa(Short estadoTipoEmpresa) {
        this.estadoTipoEmpresa = estadoTipoEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.idTipoEmpresa);
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
        final TipoEmpresa other = (TipoEmpresa) obj;
        return Objects.equals(this.idTipoEmpresa, other.idTipoEmpresa);
    }

    @Override
    public String toString() {
        return "TipoEmpresas{" + "idTipoEmpresa=" + idTipoEmpresa + ", nombreTipoEmpresa=" + nombreTipoEmpresa + ", estadoTipoEmpresa=" + estadoTipoEmpresa + '}';
    }
    
    
    
    
}
