package com.eboneth.espec.modalidad.servicio;

import com.eboneth.espec.modalidad.repositorio.ModalidadRepositorio;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ModalidadEliminarServicio {

    private final ModalidadRepositorio modalidadRepositorio;

    public ModalidadEliminarServicio(ModalidadRepositorio modalidadRepositorio) {
        this.modalidadRepositorio = modalidadRepositorio;
    }

    @Transactional
    public void eliminar(Integer id) {
        if (!modalidadRepositorio.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "No se encontró la modalidad con ID: " + id);
        }
        modalidadRepositorio.deleteById(id);
    }
}
