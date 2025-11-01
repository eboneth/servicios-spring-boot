package com.eboneth.espec.vacante.repositorio;

import com.eboneth.espec.vacante.entidad.Anuncio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vacante_AnuncionRepositorio")
public interface AnuncioRepositorio extends JpaRepository<Anuncio, Long> {
}
