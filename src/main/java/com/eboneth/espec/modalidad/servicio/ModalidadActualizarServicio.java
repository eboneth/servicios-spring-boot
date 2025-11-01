package com.eboneth.espec.modalidad.servicio;

import com.eboneth.espec.modalidad.dto.ModalidadDtoActualizar;
import com.eboneth.espec.modalidad.dto.ModalidadDtoRespuesta;
import com.eboneth.espec.modalidad.entidad.Modalidad;
import com.eboneth.espec.modalidad.repositorio.ModalidadRepositorio;
import com.eboneth.espec.modalidad.utilidad.mapeador.ModalidadMapeador;
import com.eboneth.espec.modalidad.utilidad.validacion.ModalidadValidacion;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ModalidadActualizarServicio {

    private final ModalidadRepositorio modalidadRepositorio;
    private final ModalidadMapeador modalidadMapeador;
    private final ModalidadValidacion modalidadValidacion;
    private final ModalidadLeerServicio modalidadLeerServicio;

    public ModalidadActualizarServicio(ModalidadRepositorio modalidadRepositorio,
            ModalidadMapeador modalidadMapeador,
            ModalidadValidacion modalidadValidacion,
            ModalidadLeerServicio modalidadLeerServicio) {
        this.modalidadRepositorio = modalidadRepositorio;
        this.modalidadMapeador = modalidadMapeador;
        this.modalidadValidacion = modalidadValidacion;
        this.modalidadLeerServicio = modalidadLeerServicio;
    }

    @Transactional
    public ModalidadDtoRespuesta actualizar(Integer id, ModalidadDtoActualizar dtoActualizar) {
        Modalidad entidadExistente = modalidadLeerServicio.encontrarModalidadPorId(id);
        modalidadValidacion.validarNombreUnico(dtoActualizar.getNombreModalidad(), id);
        modalidadMapeador.actualizarEntidad(dtoActualizar, entidadExistente);
        Modalidad entidadActualizada = modalidadRepositorio.save(entidadExistente);
        return modalidadMapeador.toDtoRespuesta(entidadActualizada);
    }
}
