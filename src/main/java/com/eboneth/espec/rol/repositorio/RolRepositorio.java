
package com.eboneth.espec.rol.repositorio;

import com.eboneth.espec.rol.entidad.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("rol_RolRepositorio")
public interface RolRepositorio extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByNombreRolIgnoreCase(String nombre);
}
