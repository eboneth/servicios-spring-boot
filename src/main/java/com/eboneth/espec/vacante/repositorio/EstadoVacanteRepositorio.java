package com.eboneth.espec.vacante.repositorio;

import com.eboneth.espec.vacante.entidad.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vacante_EstadoVacante")
public interface EstadoVacanteRepositorio extends JpaRepository<Vacante, Integer> {
}
