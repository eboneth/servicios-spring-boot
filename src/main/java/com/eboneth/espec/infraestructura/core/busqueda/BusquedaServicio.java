
package com.eboneth.espec.infraestructura.core.busqueda;

import com.eboneth.espec.infraestructura.excepcion.ExcepcionNegocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BusquedaServicio <T, ID> {
    
    public T porId(JpaRepository <T, ID> repositorio, ID id){
        String msj = "No se encontro el recurso 😔" + id;
        return porId(repositorio, id, msj);
    }
    
    public T porId(JpaRepository <T, ID> repositorio, ID id, String mensaje){
        repositorio.findById(id).orElseThrow(()-> new ExcepcionNegocio(mensaje));
        String msj = "No se encontro el recurso 😔" + id;
        return porId(repositorio, id, msj);
    }
}
