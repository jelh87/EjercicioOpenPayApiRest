package com.marvel.microservicio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marvel.microservicio.service.PersonajeService;

/**
 * Clase orquestadora entre vista y servicios
 */
@RestController
@RequestMapping("api/personajes")
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonajeController {
	
	/**
	 * Inyeccion de dependencia userService
	 */
	@Autowired 
	private PersonajeService userService;
	
	/**
	 * Metodo para obtener todos los personajes
	 * @return Object con todos los personajes
	 */
	@GetMapping
	public Object getAllCharacters() {
		return userService.getAllCharacters();
	}
	
	/**
	 * Metodo para obtener personaje por id
	 * @param id id del personaje
	 * @return Object con el personaje
	 */
	@GetMapping("{id}")
	public Object getCharacterById(@PathVariable("id") Long id) {
		return userService.getCharacterById(id);
	}
	
	/**
	 * Metodo para obtener todos los registros de bitacora
	 * @return Object con los registros de bitacora
	 */
	@GetMapping("/bitacora")
	public Object getBitacora() {
		return userService.getBitacora();
	}

}
