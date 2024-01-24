package com.marvel.microservicio.service;

import java.util.List;
import com.marvel.microservicio.model.Bitacora;

public interface PersonajeService {
	
	public Object getAllCharacters();
	
	public Object getCharacterById(Long id);
	
	public List<Bitacora> getBitacora();

}
