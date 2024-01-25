package com.marvel.microservicio.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.marvel.microservicio.model.AuthenticationReq;
import com.marvel.microservicio.model.TokenInfo;
import com.marvel.microservicio.service.PersonajeService;
import com.marvel.microservicio.service.impl.JwtUtilService;

/**
 * Clase orquestadora entre vista y servicios
 */
@RestController
@RequestMapping("api/personajes")
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonajeController {
	
	/**
	 * Componente del logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(PersonajeController.class);
	
	/**
	 * Inyeccion de dependencia authenticationManager
	 */
	@Autowired
	private AuthenticationManager authenticationManager;

	/**
	 * Inyeccion de dependencia usuarioDetailsService
	 */
	@Autowired
	UserDetailsService usuarioDetailsService;
	
	/**
	 * Inyeccion de dependencia jwtUtilService
	 */
	@Autowired
	private JwtUtilService jwtUtilService;
	
	/**
	 * Inyeccion de dependencia userService
	 */
	@Autowired 
	private PersonajeService userService;
	
	/**
	 * Metodo para generer el JWT
	 * @param authenticationReq authenticationReq
	 * @return ResponseEntity JWT
	 */
	@PostMapping("/authenticate")
	public ResponseEntity<TokenInfo> authenticate(@RequestBody AuthenticationReq authenticationReq) {
		LOG.info("Ingresa al metodo authenticate de la clase PersonajeController.");
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationReq.getUsuario(),
						authenticationReq.getClave()));

		final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(
				authenticationReq.getUsuario());
		final String jwt = jwtUtilService.generateToken(userDetails);
		return ResponseEntity.ok(new TokenInfo(jwt));
	}
	
	/**
	 * Metodo para obtener todos los personajes
	 * @return Object con todos los personajes
	 */
	@GetMapping
	public Object getAllCharacters() {
		LOG.info("Ingresa al metodo getAllCharacters de la clase PersonajeController.");
		return userService.getAllCharacters();
	}
	
	/**
	 * Metodo para obtener personaje por id
	 * @param id id del personaje
	 * @return Object con el personaje
	 */
	@GetMapping("{id}")
	public Object getCharacterById(@PathVariable("id") Long id) {
		LOG.info("Ingresa al metodo getCharacterById de la clase PersonajeController.");
		return userService.getCharacterById(id);
	}
	
	/**
	 * Metodo para obtener todos los registros de bitacora
	 * @return Object con los registros de bitacora
	 */
	@GetMapping("/bitacora")
	public Object getBitacora() {
		LOG.info("Ingresa al metodo getBitacora de la clase PersonajeController.");
		return userService.getBitacora();
	}

}
