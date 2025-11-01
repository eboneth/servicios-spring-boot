package com.eboneth.espec.modalidad.utilidad.mapeador;

import com.eboneth.espec.modalidad.dto.ModalidadDtoCrear;
import com.eboneth.espec.modalidad.dto.ModalidadDtoActualizar;
import com.eboneth.espec.modalidad.dto.ModalidadDtoRespuesta;

import com.eboneth.espec.modalidad.entidad.Modalidad;
import org.springframework.stereotype.Component;

@Component
public class ModalidadMapeador {

    public ModalidadDtoRespuesta toDtoRespuesta(Modalidad modalidad) {
        if (modalidad == null) {
            return null;
        }
        return new ModalidadDtoRespuesta(
                modalidad.getIdModalidad(),
                modalidad.getNombreModalidad()
        );
    }

    public Modalidad toEntidad(ModalidadDtoCrear dtoCrear) {
        if (dtoCrear == null) {
            return null;
        }
        Modalidad modalidad = new Modalidad();
        modalidad.setNombreModalidad(dtoCrear.nombreModalidad());
        return modalidad;
    }

    public void actualizarEntidad(ModalidadDtoActualizar dtoActualizar, Modalidad entidadExistente) {
        if (dtoActualizar == null || entidadExistente == null) {
            return;
        }
        entidadExistente.setNombreModalidad(dtoActualizar.getNombreModalidad());
    }
}
