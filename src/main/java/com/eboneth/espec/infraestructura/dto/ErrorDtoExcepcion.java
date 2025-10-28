package com.eboneth.espec.infraestructura.dto;

import java.time.OffsetDateTime;

public class ErrorDtoExcepcion {
    private final int codigoError;
    private final OffsetDateTime fechaHora;
    private final String error;
    private final String mensaje;

    public ErrorDtoExcepcion(int codigoError, OffsetDateTime fechaHora, String error, String mensaje) {
        this.codigoError = codigoError;
        this.fechaHora = fechaHora;
        this.error = error;
        this.mensaje = mensaje;
    }

    public int getCodigoError() {
        return codigoError;
    }

    public OffsetDateTime getFechaHora() {
        return fechaHora;
    }

    public String getError() {
        return error;
    }

    public String getMensaje() {
        return mensaje;
    }
    
    
    
}
