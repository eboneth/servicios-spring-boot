
package com.eboneth.espec.tipos_contratos.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TipoContratoDtoCrear (
        @NotNull
        @Size(min = 1, max = 150)
        String nombreTipoContrato)
        {}
