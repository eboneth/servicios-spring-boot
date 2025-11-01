package com.eboneth.espec.modalidad.servicio;


import com.eboneth.espec.modalidad.dto.ModalidadDtoRespuesta;

import com.eboneth.espec.modalidad.entidad.Modalidad;
import com.eboneth.espec.modalidad.repositorio.ModalidadRepositorio;
import com.eboneth.espec.modalidad.utilidad.mapeador.ModalidadMapeador;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional(readOnly = true)
public class ModalidadLeerServicio {

    private final ModalidadRepositorio modalidadRepositorio;
    private final ModalidadMapeador modalidadMapeador;

    public ModalidadLeerServicio(ModalidadRepositorio modalidadRepositorio, 
                                 ModalidadMapeador modalidadMapeador) {
        this.modalidadRepositorio = modalidadRepositorio;
        this.modalidadMapeador = modalidadMapeador;
    }

    public List<ModalidadDtoRespuesta> buscarTodos() {
        return modalidadRepositorio.findAll()
                .stream()
                .map(modalidadMapeador::toDtoRespuesta)
                .collect(Collectors.toList());
    }

  
    public ModalidadDtoRespuesta buscarPorId(Integer id) {
        Modalidad modalidad = encontrarModalidadPorId(id);
        return modalidadMapeador.toDtoRespuesta(modalidad);
    }

    public Modalidad encontrarModalidadPorId(Integer id) {
        return modalidadRepositorio.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No se encontró la modalidad con ID: " + id));
    }
}