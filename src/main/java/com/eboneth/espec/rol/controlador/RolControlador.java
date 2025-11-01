
package com.eboneth.espec.rol.controlador;

import com.eboneth.espec.rol.dto.RolDtoCrear;
import com.eboneth.espec.rol.dto.RolDtoRespuesta;
import com.eboneth.espec.rol.servicio.RolCrearServicio;
import com.eboneth.espec.infraestructura.utilidad.respuesta.RespuestaHttp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(originPatterns = "*")
@RequestMapping("/rol")
public class RolControlador {
   
    private final RolCrearServicio rolCrearServicio;

    public RolControlador(RolCrearServicio rolCrearServicio) {
        this.rolCrearServicio = rolCrearServicio;
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> crearTipoEmpresa(@RequestBody RolDtoCrear dto){
        RolDtoRespuesta respuesta = rolCrearServicio.crearRol(dto);
        return RespuestaHttp.ok("Tipo creado", dto);
    }
    
}