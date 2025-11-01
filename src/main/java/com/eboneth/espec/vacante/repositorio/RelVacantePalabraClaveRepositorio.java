package com.eboneth.espec.vacante.repositorio;

import com.eboneth.espec.vacante.entidad.RelVacantePalabraClave;
import com.eboneth.espec.vacante.entidad.pk.RelVacantePalabraClavePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vacante_RelVacantePalabraClave")
public interface RelVacantePalabraClaveRepositorio extends JpaRepository<RelVacantePalabraClave, RelVacantePalabraClavePK> {
}
