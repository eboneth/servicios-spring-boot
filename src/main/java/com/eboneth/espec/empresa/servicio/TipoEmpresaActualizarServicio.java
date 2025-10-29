package com.eboneth.espec.empresa.servicio;

import com.eboneth.espec.empresa.dto.TipoEmpresaDtoCrear;
import com.eboneth.espec.empresa.dto.TipoEmpresaDtoRespuesta;
import com.eboneth.espec.empresa.entidad.TipoEmpresa;
import com.eboneth.espec.empresa.repositorio.TipoEmpresaRepositorio;
import org.springframework.stereotype.Service;

@Service
public class TipoEmpresaActualizarServicio {

    private final TipoEmpresaRepositorio tipoEmpresaRepositorio;

    public TipoEmpresaActualizarServicio(TipoEmpresaRepositorio tipoEmpresaRepositorio) {
        this.tipoEmpresaRepositorio = tipoEmpresaRepositorio;
    }

    //ACTUALIZAR
    public TipoEmpresaDtoRespuesta actualizar(Integer id, TipoEmpresaDtoCrear tipoEmpresaDtoCrear) {
        TipoEmpresa tipoEmpresa = tipoEmpresaRepositorio.findById(id).orElseThrow(()-> new RuntimeException("Tipo de empresa no encontrado: " +id));
        tipoEmpresa.setNombreTipoEmpresa(tipoEmpresaDtoCrear.nombreTipoEmpresa());
        tipoEmpresa.setEstadoTipoEmpresa(tipoEmpresaDtoCrear.estadoTipoEmpresa());
        tipoEmpresaRepositorio.save(tipoEmpresa);

        return new TipoEmpresaDtoRespuesta(tipoEmpresa.getIdTipoEmpresa(), tipoEmpresa.getNombreTipoEmpresa(), tipoEmpresa.getEstadoTipoEmpresa());
    }
}
