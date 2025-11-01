package com.eboneth.espec.vacante.repositorio;

import com.eboneth.espec.vacante.entidad.HistorialEstadoVacante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vacante_HistorialEstadoVacante")
public interface HistorialEstadoVacanteRepositorio extends JpaRepository<HistorialEstadoVacante, Long> {
}
