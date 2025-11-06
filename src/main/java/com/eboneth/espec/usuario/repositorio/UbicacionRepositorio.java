package com.eboneth.espec.usuario.repositorio;

import com.eboneth.espec.usuario.entidad.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UbicacionRepositorio extends JpaRepository<Ubicacion, Integer> {
}
