
package com.eboneth.espec.empresa.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TipoEmpresaDtoActualizar {
    
    @NotNull
    private Integer idTipoEmpresa;
    
    @Size(min=1, max=150)
    private String nombreTipoEmpresa;
    
    private Short estadoTipoEmpresa;

    public TipoEmpresaDtoActualizar() {
    }

    public TipoEmpresaDtoActualizar(Integer idTipoEmpresa, String nombreTipoEmpresa, Short estadoTipoEmpresa) {
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
    
}
