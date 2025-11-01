package com.eboneth.espec.vacante.controlador;

import com.eboneth.espec.infraestructura.utilidad.respuesta.RespuestaHttp;
import com.eboneth.espec.vacante.dto.VacanteDtoCrear;
import com.eboneth.espec.vacante.dto.VacanteDtoRespuesta;
import com.eboneth.espec.vacante.entidad.Vacante;
import com.eboneth.espec.vacante.servicio.VacanteCrearServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vacancy")
public class VacanteCrearControlador {

    private final VacanteCrearServicio vacanteCrearServicio;

    public VacanteCrearControlador(VacanteCrearServicio vacanteCrearServicio) {
        this.vacanteCrearServicio = vacanteCrearServicio;
    }

    @PostMapping("/add")
    public ResponseEntity<?> nuevaVacante (@ModelAttribute VacanteDtoCrear vacanteDtoCrear) {
        MultipartFile archivo = vacanteDtoCrear.getArchivo();
        VacanteDtoRespuesta vacanteDtoRespuesta = vacanteCrearServicio.CrearVacante(vacanteDtoCrear, null);
        return RespuestaHttp.ok("Vacante creado correctamente", vacanteDtoRespuesta);
    }
}
