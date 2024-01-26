package com.marvel.microservicio.service;

/**
 * Interfaz 
 */
public interface PersonajeService {
	
	/**
	 * Metodo para obtener todos los personajes
	 * @return Object con todos los personajes
	 */
	public Object getAllCharacters();
	
	/**
	 * Metodo para obtener personaje por id
	 * @param id id del personaje
	 */
	public Object getCharacterById(Long id);

}
