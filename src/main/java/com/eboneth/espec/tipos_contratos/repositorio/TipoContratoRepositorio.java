
package com.eboneth.espec.tipos_contratos.repositorio;

import com.eboneth.espec.tipos_contratos.entity.TipoContrato;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository("vacante_TipoContratoRepositorio")
public interface TipoContratoRepositorio extends JpaRepository<TipoContrato, Integer> {
    Optional<TipoContrato> findByNombreTipoContratoIgnoreCase(String nombre);
}
