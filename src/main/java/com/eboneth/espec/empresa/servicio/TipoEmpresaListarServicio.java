package com.eboneth.espec.empresa.servicio;

import com.eboneth.espec.empresa.dto.TipoEmpresaDtoRespuesta;
import com.eboneth.espec.empresa.entidad.TipoEmpresa;
import com.eboneth.espec.empresa.repositorio.TipoEmpresaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoEmpresaListarServicio {

    private final TipoEmpresaRepositorio tipoEmpresaRepositorio;

    public TipoEmpresaListarServicio(TipoEmpresaRepositorio tipoEmpresaRepositorio) {
        this.tipoEmpresaRepositorio = tipoEmpresaRepositorio;
    }

    public List<TipoEmpresaDtoRespuesta> listarTodos() {
        List<TipoEmpresa> tiposEmpresas = tipoEmpresaRepositorio.findAll();

        return tiposEmpresas.stream()
                .map(e-> new TipoEmpresaDtoRespuesta(e.getIdTipoEmpresa(), e.getNombreTipoEmpresa(), e.getEstadoTipoEmpresa()))
                .collect(Collectors.toList());
    }

    public TipoEmpresaDtoRespuesta buscarPorId(Integer id) {
        Optional<TipoEmpresa> entidad = tipoEmpresaRepositorio.findById(id);
        if (entidad.isEmpty()){
            throw new RuntimeException("Tipo de empresa no encontrado: " +id);
        }
        TipoEmpresa tipoEmpresa = entidad.get();
        return new TipoEmpresaDtoRespuesta(tipoEmpresa.getIdTipoEmpresa(), tipoEmpresa.getNombreTipoEmpresa(), tipoEmpresa.getEstadoTipoEmpresa());
    }
}
