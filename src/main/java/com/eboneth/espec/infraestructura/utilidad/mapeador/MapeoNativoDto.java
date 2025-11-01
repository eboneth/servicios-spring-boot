package com.eboneth.espec.infraestructura.utilidad.mapeador;

import jakarta.persistence.Tuple;

public interface MapeoNativoDto <D> {
    D mapearDesdeTupla(Tuple miTupla);
}
