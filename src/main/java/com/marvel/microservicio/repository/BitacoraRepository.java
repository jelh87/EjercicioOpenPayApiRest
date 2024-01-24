package com.marvel.microservicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.marvel.microservicio.model.Bitacora;

/**
 * Repositorio
 */
@Repository
public interface BitacoraRepository extends JpaRepository<Bitacora,Long>{

}
