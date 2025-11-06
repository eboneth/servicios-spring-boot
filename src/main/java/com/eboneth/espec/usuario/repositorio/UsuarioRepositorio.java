package com.eboneth.espec.usuario.repositorio;

import com.eboneth.espec.usuario.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("usuario_UsuarioRepositorio")
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
}
