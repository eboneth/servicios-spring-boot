
package com.eboneth.espec.rol.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RolDtoCrear (@NotNull
        @Size(min = 1, max = 150)
        String nombreRol,
        
        @NotNull
        Short estadoRol) {
    
}
