
package com.eboneth.espec.rol.entidad;

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

@Table(name = "roles", indexes = @Index(name = "idx_nombre_unico", columnList= "nombre_rol"))
@Entity(name = "rol_Rol")
public class Rol implements Serializable{
     private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol", nullable = false)
    private Integer idRol;
    
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_rol", nullable = false, unique = true, length = 150)
    private String nombreRol;
    
    @NotNull
    @Column(name = "estado_rol", nullable = false)
    private Short estadoRol;

    public Rol() {
    }

    public Rol(Integer idTipoRol) {
        this.idRol = idRol;
    }

    public Rol(Integer idTipoRol, String nombreRol, Short estadoRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.estadoRol = estadoRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idTipoRol) {
        this.idRol = idTipoRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Short getEstadoRol() {
        return estadoRol;
    }

    public void setEstadoRol(Short estadoRol) {
        this.estadoRol = estadoRol;
    }
    
    
}
