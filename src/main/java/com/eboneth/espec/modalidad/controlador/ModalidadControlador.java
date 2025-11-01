package com.eboneth.espec.modalidad.controlador;

import com.eboneth.espec.modalidad.dto.ModalidadDtoCrear;
import com.eboneth.espec.modalidad.dto.ModalidadDtoActualizar;
import com.eboneth.espec.modalidad.dto.ModalidadDtoRespuesta;
import com.eboneth.espec.modalidad.servicio.ModalidadCrearServicio;
import com.eboneth.espec.modalidad.servicio.ModalidadActualizarServicio;
import com.eboneth.espec.modalidad.servicio.ModalidadEliminarServicio;
import com.eboneth.espec.modalidad.servicio.ModalidadLeerServicio;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modalidad")
public class ModalidadControlador {


    private final ModalidadCrearServicio modalidadCrearServicio;
    private final ModalidadLeerServicio modalidadLeerServicio;
    private final ModalidadActualizarServicio modalidadActualizarServicio;
    private final ModalidadEliminarServicio modalidadEliminarServicio;

    public ModalidadControlador(ModalidadCrearServicio modalidadCrearServicio,
                                ModalidadLeerServicio modalidadLeerServicio,
                                ModalidadActualizarServicio modalidadActualizarServicio,
                                ModalidadEliminarServicio modalidadEliminarServicio) {
        this.modalidadCrearServicio = modalidadCrearServicio;
        this.modalidadLeerServicio = modalidadLeerServicio;
        this.modalidadActualizarServicio = modalidadActualizarServicio;
        this.modalidadEliminarServicio = modalidadEliminarServicio;
    }

 
    @PostMapping
    public ResponseEntity<ModalidadDtoRespuesta> crearModalidad(
            @Valid @RequestBody ModalidadDtoCrear dtoCrear) {
        ModalidadDtoRespuesta nuevaModalidad = modalidadCrearServicio.crear(dtoCrear);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaModalidad);
    }

  
    @GetMapping
    public ResponseEntity<List<ModalidadDtoRespuesta>> obtenerTodas() {
        List<ModalidadDtoRespuesta> modalidades = modalidadLeerServicio.buscarTodos();
        return ResponseEntity.ok(modalidades);
    }

   
    @GetMapping("/{id}")
    public ResponseEntity<ModalidadDtoRespuesta> obtenerPorId(@PathVariable Integer id) {
        ModalidadDtoRespuesta modalidad = modalidadLeerServicio.buscarPorId(id);
        return ResponseEntity.ok(modalidad);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ModalidadDtoRespuesta> actualizarModalidad(
            @PathVariable Integer id,
            @Valid @RequestBody ModalidadDtoActualizar dtoActualizar) {
        
        ModalidadDtoRespuesta modalidadActualizada = modalidadActualizarServicio.actualizar(id, dtoActualizar);
        return ResponseEntity.ok(modalidadActualizada);
    }

 
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarModalidad(@PathVariable Integer id) {
        modalidadEliminarServicio.eliminar(id);
        return ResponseEntity.noContent().build(); 
    }
}