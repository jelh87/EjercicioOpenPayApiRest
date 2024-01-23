package com.marvel.microservicio.service;

import java.util.List;
import com.marvel.microservicio.model.Bitacora;
import com.marvel.microservicio.model.Personaje;

public interface PersonajeService {
	
	public Object getAllCharacters();
	
	public Personaje getCharacterById(Long id);
	
	public List<Bitacora> getBitacora();

}
