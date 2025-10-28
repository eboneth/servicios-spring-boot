package com.eboneth.espec.utilidad.mapeador;

public interface MapeoEntidadDto <E,D> {
    D desdeEntidad(E entidad);
    E desdeDto(D dto);
}
