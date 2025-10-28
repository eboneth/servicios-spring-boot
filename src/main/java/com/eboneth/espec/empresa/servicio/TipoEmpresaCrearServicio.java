
package com.eboneth.espec.empresa.servicio;

import com.eboneth.espec.empresa.dto.TipoEmpresaDtoCrear;
import com.eboneth.espec.empresa.dto.TipoEmpresaDtoRespuesta;
import com.eboneth.espec.empresa.entidad.TipoEmpresa;
import com.eboneth.espec.empresa.repositorio.TipoEmpresaRepositorio;
import com.eboneth.espec.empresa.utilidad.mapeador.TipoEmpresaMapeador;
import com.eboneth.espec.empresa.utilidad.validacion.TipoEmpresaValidacion;
import com.eboneth.espec.infraestructura.core.busqueda.BusquedaServicio;
import com.eboneth.espec.infraestructura.core.crud.OperacionCrudImplementacion;
import com.eboneth.espec.infraestructura.excepcion.ExcepcionNegocio;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoEmpresaCrearServicio extends OperacionCrudImplementacion<TipoEmpresa, Integer>{

    private final TipoEmpresaRepositorio tipoEmpresaRepositorio;
    private final TipoEmpresaMapeador tipoEmpresaMapeador;

    public TipoEmpresaCrearServicio(TipoEmpresaRepositorio tipoEmpresaRepositorio, 
            TipoEmpresaMapeador tipoEmpresaMapeador, 
            BusquedaServicio<TipoEmpresa, Integer> servicioBuscar) {
        super(servicioBuscar);
        this.tipoEmpresaRepositorio = tipoEmpresaRepositorio;
        this.tipoEmpresaMapeador = tipoEmpresaMapeador;
    }
    
    @Override
    protected JpaRepository<TipoEmpresa, Integer> getRepositorio() {  
        return tipoEmpresaRepositorio;
    }
    
    private void verificarExistenciaTipoEmpresa(String nombre){
        Optional<TipoEmpresa> existente = tipoEmpresaRepositorio.findByNombreTipoEmpresaIgnoreCase(nombre);
        if (existente.isPresent()) {
            throw new ExcepcionNegocio("El nombre de la empresa ya existe!!!!");
        }
    }
    
    public TipoEmpresaDtoRespuesta crearTipoEmpresa(TipoEmpresaDtoCrear tipoEmpresa){
        String nombreSinEspacio = tipoEmpresa.nombreTipoEmpresa().trim();
        Short estado = TipoEmpresaValidacion.estadoAjustado(tipoEmpresa.estadoTipoEmpresa());
        
        TipoEmpresaValidacion.validarNombre(nombreSinEspacio);
        verificarExistenciaTipoEmpresa(nombreSinEspacio);
        
        TipoEmpresa objNuevo = new TipoEmpresa();
        objNuevo.setNombreTipoEmpresa(nombreSinEspacio);
        objNuevo.setEstadoTipoEmpresa(estado);
        
        TipoEmpresa registrada = agregar(objNuevo);
        return tipoEmpresaMapeador.desdeEntidad(registrada);
    }
    
}
