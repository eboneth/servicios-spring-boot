
package com.eboneth.espec.rol.servicio;

import com.eboneth.espec.infraestructura.core.busqueda.BusquedaServicio;
import com.eboneth.espec.rol.entidad.Rol;
import com.eboneth.espec.infraestructura.core.crud.OperacionCrudImplementacion;
import com.eboneth.espec.infraestructura.excepcion.ExcepcionNegocio;
import com.eboneth.espec.rol.dto.RolDtoCrear;
import com.eboneth.espec.rol.dto.RolDtoRespuesta;
import com.eboneth.espec.rol.repositorio.RolRepositorio;
import com.eboneth.espec.rol.utilidad.mapeador.RolMapeador;
import com.eboneth.espec.rol.utilidad.validacion.RolValidacion;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RolCrearServicio extends OperacionCrudImplementacion<Rol, Integer> {
    private final RolRepositorio rolRepositorio;
    private final RolMapeador rolMapeador;
    
    public RolCrearServicio(RolRepositorio rolRepositorio, 
            RolMapeador rolMapeador, 
            BusquedaServicio<Rol, Integer> servicioBuscar) {
        super(servicioBuscar);
        this.rolRepositorio = rolRepositorio;
        this.rolMapeador = rolMapeador;
    }
    
    @Override
    protected JpaRepository<Rol, Integer> getRepositorio() {  
        return rolRepositorio;
    }
    
    private void verificarExistenciaRol(String nombre){
        Optional<Rol> existente = rolRepositorio.findByNombreRolIgnoreCase(nombre);
        if (existente.isPresent()) {
            throw new ExcepcionNegocio("El nombre del rol ya existe!!!!");
        }
    }
    
    public RolDtoRespuesta crearRol(RolDtoCrear rol){
        String nombreSinEspacio = rol.nombreRol().trim();
        Short estado = RolValidacion.estadoAjustado(rol.estadoRol());
        
        RolValidacion.validarNombre(nombreSinEspacio);
        verificarExistenciaRol(nombreSinEspacio);
        
        Rol objNuevo = new Rol();
        objNuevo.setNombreRol(nombreSinEspacio);
        objNuevo.setEstadoRol(estado);
        
        Rol registrado = agregar(objNuevo);
        return rolMapeador.desdeEntidad(registrado);
    }
    
}
