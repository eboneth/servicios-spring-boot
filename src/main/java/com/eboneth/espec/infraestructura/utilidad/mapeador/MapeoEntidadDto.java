package com.eboneth.espec.infraestructura.utilidad.mapeador;

import com.eboneth.espec.infraestructura.excepcion.ExcepcionNegocio;

public interface MapeoEntidadDto <E,D> {
    D desdeEntidad(E entidad);
    E desdeDto(D dto);

    default E desdeDto(D dto, Object... objetosExternos) {
        throw new ExcepcionNegocio("El mapeador no esta implementado");
    }
}
