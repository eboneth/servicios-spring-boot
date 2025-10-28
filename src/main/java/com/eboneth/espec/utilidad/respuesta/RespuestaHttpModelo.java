/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eboneth.espec.utilidad.respuesta;

import java.time.OffsetDateTime;

public class RespuestaHttpModelo <T>{
    private final int codigoEstado;
    private final OffsetDateTime fechaHora;
    private final String mensaje;
    private final T datos;

    public RespuestaHttpModelo(int codigoEstado, String mensaje, T datos) {
        this.codigoEstado = codigoEstado;
        this.fechaHora = OffsetDateTime.now();
        this.mensaje = mensaje;
        this.datos = datos;
    }

    public int getCodigoEstado() {
        return codigoEstado;
    }

    public OffsetDateTime getFechaHora() {
        return fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public T getDatos() {
        return datos;
    }
    
    
}
