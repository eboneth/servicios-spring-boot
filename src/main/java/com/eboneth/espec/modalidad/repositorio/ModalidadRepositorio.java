package com.eboneth.espec.modalidad.repositorio;

import com.eboneth.espec.modalidad.entidad.Modalidad;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("modalidad_modalidadRepositorio")
public interface ModalidadRepositorio extends JpaRepository<Modalidad, Integer> {
    Optional<Modalidad> findByNombreModalidadIgnoreCase(String nombre);
    boolean existsByNombreModalidadIgnoreCase(String nombre);
}