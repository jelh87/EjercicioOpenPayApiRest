package com.marvel.microservicio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marvel.microservicio.model.Personaje;
import com.marvel.microservicio.service.PersonajeService;

@RestController
@RequestMapping("api/personajes")
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonajeController {
	
	//Inyeccion de dependencia
	@Autowired 
	private PersonajeService userService;
	
	//Para poder exponer el metodo y obtener todos los personajes
	@GetMapping
	public Object getAllCharacters() {
		return userService.getAllCharacters();
	}
	
	//Para poder exponer el metodo y obtener objeto recibiendo un parametro del cliente a traves de la URL
	@GetMapping("{id}")
	public Personaje getCharacterById(@PathVariable("id") Long id) {
		return userService.getCharacterById(id);
	}

}
