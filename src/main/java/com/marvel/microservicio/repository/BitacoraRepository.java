package com.marvel.microservicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.marvel.microservicio.model.Bitacora;

public interface BitacoraRepository extends JpaRepository<Bitacora,Long>{

}
