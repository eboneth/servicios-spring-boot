package com.eboneth.espec.vacante.repositorio;

import com.eboneth.espec.vacante.entidad.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vacante_VacanteRepositorio")
public interface VacanteRepositorio extends JpaRepository<Vacante, Integer> {

}
