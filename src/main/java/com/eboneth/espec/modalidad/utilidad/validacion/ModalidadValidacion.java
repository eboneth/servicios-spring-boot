package com.eboneth.espec.modalidad.utilidad.validacion;

import com.eboneth.espec.modalidad.repositorio.ModalidadRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class ModalidadValidacion {

    private final ModalidadRepositorio modalidadRepositorio;

    public ModalidadValidacion(ModalidadRepositorio modalidadRepositorio) {
        this.modalidadRepositorio = modalidadRepositorio;
    }

   
    public void validarNombreUnico(String nombreModalidad) {
        if (modalidadRepositorio.existsByNombreModalidadIgnoreCase(nombreModalidad)) {
            // Si ya existe, lanzamos un error 409 CONFLICT
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "El nombre de modalidad '" + nombreModalidad + "' ya existe.");
        }
    }

    public void validarNombreUnico(String nombreModalidad, Integer idActual) {
        modalidadRepositorio.findByNombreModalidadIgnoreCase(nombreModalidad)
            .ifPresent(modalidad -> {
                if (!modalidad.getIdModalidad().equals(idActual)) {
                    throw new ResponseStatusException(HttpStatus.CONFLICT,
                            "El nombre de modalidad '" + nombreModalidad + "' ya le pertenece a otro registro.");
                }
            });
    }
}