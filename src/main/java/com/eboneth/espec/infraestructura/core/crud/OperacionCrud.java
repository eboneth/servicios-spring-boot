package com.eboneth.espec.infraestructura.core.crud;

import java.util.List;
import org.springframework.data.domain.Sort;

public interface OperacionCrud <T, ID>{
    
    Long cantidadRegistros();
    T agregar(T miEntidad);
    List<T> consultarTodos(Sort sort);
    T buscarPorId(ID id);
    T buscarPorId(ID id, String mensaje);
    boolean eliminar(ID id);
    T actualizar(T miEntidad); 
}
