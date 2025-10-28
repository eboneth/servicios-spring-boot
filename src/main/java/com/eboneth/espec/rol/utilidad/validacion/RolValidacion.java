
package com.eboneth.espec.rol.utilidad.validacion;

import com.eboneth.espec.infraestructura.excepcion.ExcepcionValidacion;

public class RolValidacion {
    private static final int LONGITUD = 150;

    public RolValidacion() {
    }
    
    private static void validarNombreVacio(String nombre){
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ExcepcionValidacion("Nombre rol es requerido");
        }
    }
    
    public static void validarLogintud (String nombre, int maximo){
        if (nombre.trim().length() > maximo) {
            throw new ExcepcionValidacion("Longitud del nombre superada");
        }
    }
    
    public static void validarNombre (String nombre){
        validarNombreVacio(nombre);
        validarLogintud(nombre, LONGITUD);
    }
    
    public static Short estadoAjustado(Short valorEstado){
        if (valorEstado == null || valorEstado < 1 || valorEstado > 3) {
            return 1;
        }
        return valorEstado;
    }
}
