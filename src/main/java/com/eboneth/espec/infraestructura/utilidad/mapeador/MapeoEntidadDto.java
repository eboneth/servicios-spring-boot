package com.eboneth.espec.infraestructura.utilidad.mapeador;

public interface MapeoEntidadDto <E,D> {
    D desdeEntidad(E entidad);
    E desdeDto(D dto);
}
