package com.eboneth.espec.estadovacante.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EstadoVacanteDtoActualizar {
    @NotNull
    private Integer idEstadoVacante;
    @NotNull
    @Size(min = 1, max = 100)
    private String nombreEstadoVacante;
    private Short ordenEstadoVacante;
    public EstadoVacanteDtoActualizar() {
    }

    public EstadoVacanteDtoActualizar(Integer idEstadoVacante, String nombreEstadoVacante, Short ordenEstadoVacante) {
        this.idEstadoVacante = idEstadoVacante;
        this.nombreEstadoVacante = nombreEstadoVacante;
        this.ordenEstadoVacante = ordenEstadoVacante;
    }

    public @NotNull Integer getIdEstadoVacante() {
        return idEstadoVacante;
    }

    public void setIdEstadoVacante(@NotNull Integer idEstadoVacante) {
        this.idEstadoVacante = idEstadoVacante;
    }

    public @NotNull @Size(min = 1, max = 100) String getNombreEstadoVacante() {
        return nombreEstadoVacante;
    }

    public void setNombreEstadoVacante(@NotNull @Size(min = 1, max = 100) String nombreEstadoVacante) {
        this.nombreEstadoVacante = nombreEstadoVacante;
    }

    public Short getOrdenEstadoVacante() {
        return ordenEstadoVacante;
    }

    public void setOrdenEstadoVacante(Short ordenEstadoVacante) {
        this.ordenEstadoVacante = ordenEstadoVacante;
    }
}
