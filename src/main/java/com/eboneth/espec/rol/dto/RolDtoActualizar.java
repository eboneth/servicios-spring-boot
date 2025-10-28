/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eboneth.espec.rol.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RolDtoActualizar {
    @NotNull
    private Integer idRol;
    
    @Size(min=1, max=150)
    private String nombreRol;
    
    private Short estadoRol;

    public RolDtoActualizar() {
    }

    public RolDtoActualizar(Integer idRol) {
        this.idRol = idRol;
    }

    public RolDtoActualizar(Integer idRol, String nombreRol, Short estadoRol) {
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.estadoRol = estadoRol;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
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
