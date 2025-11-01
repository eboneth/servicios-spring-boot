package com.eboneth.espec.modalidad.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ModalidadDtoActualizar {

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 150, message = "El nombre no puede exceder los 150 caracteres")
    private String nombreModalidad;

    public ModalidadDtoActualizar() {
    }

    public ModalidadDtoActualizar(String nombreModalidad) {
        this.nombreModalidad = nombreModalidad;
    }

    public String getNombreModalidad() {
        return nombreModalidad;
    }

    public void setNombreModalidad(String nombreModalidad) {
        this.nombreModalidad = nombreModalidad;
    }
}