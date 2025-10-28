package com.eboneth.espec.infraestructura.excepcion;

public class ExcepcionSeguridad extends RuntimeException {

    public ExcepcionSeguridad(String message) {
        super(message);
    }
    
}
