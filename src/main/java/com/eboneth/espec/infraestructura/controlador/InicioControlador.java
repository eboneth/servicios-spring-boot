package com.eboneth.espec.infraestructura.controlador;

import com.eboneth.espec.utilidad.respuesta.RespuestaHttp;
import com.eboneth.espec.utilidad.respuesta.RespuestaHttpModelo;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InicioControlador {
    
    private final Environment env;
   
    public InicioControlador(Environment env){
        this.env = env;
    }
    
    private Map <String, Object> construirRespuesta(){
        Map <String, Object> map = new LinkedHashMap<>();
        map.put("Nombre:"," 🧑🏻‍💻 Especialización 2025 🧑🏻‍💻");
        map.put("version","0.2.0");
        map.put("Estado", "Ok ✅");
        map.put("Profile", env.getActiveProfiles() );
        return map;
    }
    
    @GetMapping("/")
    public ResponseEntity<RespuestaHttpModelo<Map<String, Object>>> bienvenida(){
        return RespuestaHttp.ok("Servicio iniciado correctamente ✅",construirRespuesta());
    }
   
}
