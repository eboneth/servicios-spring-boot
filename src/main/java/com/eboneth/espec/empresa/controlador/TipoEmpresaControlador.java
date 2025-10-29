package com.eboneth.espec.empresa.controlador;

import com.eboneth.espec.empresa.dto.TipoEmpresaDtoCrear;
import com.eboneth.espec.empresa.dto.TipoEmpresaDtoRespuesta;
import com.eboneth.espec.empresa.servicio.TipoEmpresaCrearServicio;
import com.eboneth.espec.empresa.servicio.TipoEmpresaListarServicio;
import com.eboneth.espec.empresa.servicio.TipoEmpresaActualizarServicio;
import com.eboneth.espec.utilidad.respuesta.RespuestaHttp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/company-type")
public class TipoEmpresaControlador {
    private final TipoEmpresaCrearServicio tipoEmpresaCrearServicio;
    private final TipoEmpresaListarServicio tipoEmpresaListarServicio;
    private final TipoEmpresaActualizarServicio tipoEmpresaActualizarServicio;

    public TipoEmpresaControlador(TipoEmpresaCrearServicio tipoEmpresaCrearServicio,
                                  TipoEmpresaListarServicio tipoEmpresaListarServicio,
                                  TipoEmpresaActualizarServicio tipoEmpresaActualizarServicio) {
        this.tipoEmpresaCrearServicio = tipoEmpresaCrearServicio;
        this.tipoEmpresaListarServicio = tipoEmpresaListarServicio;
        this.tipoEmpresaActualizarServicio = tipoEmpresaActualizarServicio;
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> crearTipoEmpresa(@RequestBody TipoEmpresaDtoCrear dto){
        TipoEmpresaDtoRespuesta respuesta = tipoEmpresaCrearServicio.crearTipoEmpresa(dto);
        return RespuestaHttp.ok("Tipo creado", dto);
    }

    @GetMapping("/listAll")
    public ResponseEntity<?> listarTipoEmpresa(){
        List<TipoEmpresaDtoRespuesta> lista = tipoEmpresaListarServicio.listarTodos();
        return RespuestaHttp.ok("Listado de servicios exitoso", lista);
    }

    @GetMapping("/listOne/{id}")
    public ResponseEntity<?> listarTipoEmpresa(@PathVariable("id") Integer id){
        TipoEmpresaDtoRespuesta tipoEmpresaDtoRespuesta = tipoEmpresaListarServicio.buscarPorId(id);
        return RespuestaHttp.ok("Tipo de Empresa encontrada con exito", tipoEmpresaDtoRespuesta);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> actualizarTipoEmpresa(@PathVariable Integer id, @RequestBody TipoEmpresaDtoCrear dto) {
        TipoEmpresaDtoRespuesta actualizado = tipoEmpresaActualizarServicio.actualizar(id, dto);
        return RespuestaHttp.ok("Tipo de empresa actualizado", actualizado);
    }
    
}
