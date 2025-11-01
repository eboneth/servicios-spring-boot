
package com.eboneth.espec.tipos_contratos.controlador;

import com.eboneth.espec.infraestructura.utilidad.respuesta.RespuestaHttp;
import com.eboneth.espec.tipos_contratos.dto.TipoContratoDtoCrear;
import com.eboneth.espec.tipos_contratos.dto.TipoContratoDtoRespuesta;
import com.eboneth.espec.tipos_contratos.servicio.TipoContratoCrearServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/tipos_contratos-type")
public class TipoContratoControlador {
    private  final TipoContratoCrearServicio tipoContratoCrearServicio;

    public TipoContratoControlador(TipoContratoCrearServicio tipoContratoCrearServicio) {
        this.tipoContratoCrearServicio = tipoContratoCrearServicio;
    }

    @PostMapping("/add")
    public ResponseEntity<?> crearTipoContrato(@RequestBody TipoContratoDtoCrear dto) {
        TipoContratoDtoRespuesta respuesta = tipoContratoCrearServicio.crearTipoContrato(dto);
        return RespuestaHttp.ok("That is working", respuesta);
    }
}
