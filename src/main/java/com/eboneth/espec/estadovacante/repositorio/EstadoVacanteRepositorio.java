package com.eboneth.espec.estadovacante.repositorio;

import com.eboneth.espec.estadovacante.entidad.EstadoVacante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("estadovcante_EstadoVacanteRepositorio")
public interface EstadoVacanteRepositorio extends JpaRepository<EstadoVacante, Integer> {
    Optional<EstadoVacante> findByNombreEstadoVacanteIgnoreCase(String nombre);
}