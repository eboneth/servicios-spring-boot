package com.eboneth.espec.estadovacante.controlador;

import com.eboneth.espec.estadovacante.dto.EstadoVacanteDtoCrear;
import com.eboneth.espec.estadovacante.dto.EstadoVacanteDtoRespuesta;
import com.eboneth.espec.estadovacante.servicio.EstadoVacanteCrearServicio;
import com.eboneth.espec.infraestructura.utilidad.respuesta.RespuestaHttp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/vacant-estate")
public class EstadoVacanteControlador {
    private  final EstadoVacanteCrearServicio estadoVacanteCrearServicio;

    public EstadoVacanteControlador(EstadoVacanteCrearServicio estadoVacanteCrearServicio) {
        this.estadoVacanteCrearServicio = estadoVacanteCrearServicio;
    }

    @PostMapping("/add")
    public ResponseEntity<?> crearTipoEmpresa(@RequestBody EstadoVacanteDtoCrear dto) {
        EstadoVacanteDtoRespuesta respuesta = estadoVacanteCrearServicio.crearEstadoVacante(dto);
        return RespuestaHttp.ok("That is working", respuesta);
    }
}

