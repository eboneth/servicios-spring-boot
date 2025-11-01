
package com.eboneth.espec.tipos_contratos.servicio;

import com.eboneth.espec.infraestructura.core.crud.OperacionCrudImplementacion;
import com.eboneth.espec.infraestructura.core.busqueda.BusquedaServicio;
import com.eboneth.espec.infraestructura.excepcion.ExcepcionNegocio;
import com.eboneth.espec.tipos_contratos.dto.TipoContratoDtoCrear;
import com.eboneth.espec.tipos_contratos.dto.TipoContratoDtoRespuesta;
import com.eboneth.espec.tipos_contratos.entity.TipoContrato;
import com.eboneth.espec.tipos_contratos.repositorio.TipoContratoRepositorio;
import com.eboneth.espec.tipos_contratos.utilidad.mapeador.TipoContratoMapeador;
import com.eboneth.espec.tipos_contratos.utilidad.validacion.TipoContratoValidar;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoContratoCrearServicio extends OperacionCrudImplementacion<TipoContrato, Integer> {
    
        private final TipoContratoRepositorio tipoContratoRepositorio;
        private final TipoContratoMapeador tipoContratoMapeador;
        
public TipoContratoCrearServicio(TipoContratoRepositorio tipoContratoRepositorio,
                                    TipoContratoMapeador tipoContratoMapeador,
                                    BusquedaServicio<TipoContrato, Integer> searchService) {
        super(searchService);
        this.tipoContratoRepositorio = tipoContratoRepositorio;
        this.tipoContratoMapeador = tipoContratoMapeador;
    }

    @Override
    protected JpaRepository<TipoContrato, Integer> getRepositorio() {
        return tipoContratoRepositorio;
    }
    
    private void verificarExistenciaTipoContrato(String nombre) {
        Optional<TipoContrato> existente = tipoContratoRepositorio.findByNombreTipoContratoIgnoreCase(nombre);
        if(existente.isPresent()) {
            throw new ExcepcionNegocio("Ya existe " + nombre);
        }
    }
    
    public TipoContratoDtoRespuesta crearTipoContrato(TipoContratoDtoCrear dto) {
        String nombreSinEspacios = dto.nombreTipoContrato().trim();
        TipoContratoValidar.validarNombre(nombreSinEspacios);
        verificarExistenciaTipoContrato(nombreSinEspacios);
        TipoContrato objetoNuevo = new TipoContrato();
        objetoNuevo.setNombreTipoContrato(nombreSinEspacios);
        TipoContrato registrada = agregar(objetoNuevo);
        return tipoContratoMapeador.desdeEntidad(registrada);
    }
}
