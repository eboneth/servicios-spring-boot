package com.eboneth.espec.modalidad.servicio;

import com.eboneth.espec.modalidad.dto.ModalidadDtoCrear;
import com.eboneth.espec.modalidad.dto.ModalidadDtoRespuesta;

import com.eboneth.espec.modalidad.entidad.Modalidad;
import com.eboneth.espec.modalidad.repositorio.ModalidadRepositorio;
import com.eboneth.espec.modalidad.utilidad.mapeador.ModalidadMapeador;
import com.eboneth.espec.modalidad.utilidad.validacion.ModalidadValidacion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModalidadCrearServicio {

    private final ModalidadRepositorio modalidadRepositorio;
    private final ModalidadMapeador modalidadMapeador;
    private final ModalidadValidacion modalidadValidacion;

    public ModalidadCrearServicio(ModalidadRepositorio modalidadRepositorio,
            ModalidadMapeador modalidadMapeador,
            ModalidadValidacion modalidadValidacion) {
        this.modalidadRepositorio = modalidadRepositorio;
        this.modalidadMapeador = modalidadMapeador;
        this.modalidadValidacion = modalidadValidacion;
    }

    @Transactional
    public ModalidadDtoRespuesta crear(ModalidadDtoCrear dtoCrear) {
        modalidadValidacion.validarNombreUnico(dtoCrear.nombreModalidad());
        Modalidad nuevaModalidad = modalidadMapeador.toEntidad(dtoCrear);
        nuevaModalidad = modalidadRepositorio.save(nuevaModalidad);
        return modalidadMapeador.toDtoRespuesta(nuevaModalidad);
    }
}
