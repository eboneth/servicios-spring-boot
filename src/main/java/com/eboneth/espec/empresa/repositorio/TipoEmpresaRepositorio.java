
package com.eboneth.espec.empresa.repositorio;

import com.eboneth.espec.empresa.entidad.TipoEmpresa;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("empresa_TipoEmpresaRepositorio")
public interface TipoEmpresaRepositorio extends JpaRepository<TipoEmpresa, Integer>{
    Optional<TipoEmpresa> findByNombreTipoEmpresaIgnoreCase(String nombre);
}
