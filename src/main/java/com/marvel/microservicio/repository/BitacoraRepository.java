package com.marvel.microservicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marvel.microservicio.model.Bitacora;

/**
 * Repositorio
 */
public interface BitacoraRepository extends JpaRepository<Bitacora,Long>{

}
