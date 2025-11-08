package com.eboneth.espec.vacante.controlador;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eboneth.espec.infraestructura.utilidad.respuesta.RespuestaHttp;
import com.eboneth.espec.vacante.dto.VacanteDtoConsulta;
import com.eboneth.espec.vacante.servicio.VacanteConsultaServicio;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vacancy")
public class VacanteConsultaControlador {

    private final VacanteConsultaServicio vacanteConsultaServicio;

    public VacanteConsultaControlador(VacanteConsultaServicio vacanteConsultaServicio) {
        this.vacanteConsultaServicio = vacanteConsultaServicio;
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> consultarLasVacantes(
        @RequestParam(defaultValue = "v.id_vacante") String campoOrden,
        @RequestParam(defaultValue = "ASC") String tipoOrden)
    {

            List<VacanteDtoConsulta> resultado = vacanteConsultaServicio.consultaVacante(campoOrden, tipoOrden);
            if (resultado.isEmpty()) {
                return RespuestaHttp.sinContenido("No hay vacantes");
            }

            return RespuestaHttp.ok("Estas son las vacntes disponibles", resultado);
    }
    
}
