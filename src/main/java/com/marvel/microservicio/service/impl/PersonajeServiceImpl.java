package com.marvel.microservicio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.marvel.microservicio.model.Bitacora;
import com.marvel.microservicio.repository.BitacoraRepository;
import com.marvel.microservicio.service.PersonajeService;
import com.marvel.microservicio.utils.Utils;

//Para poder inyectarla como componente al Controller
/**
 * Clase que implementa la interfaz
 */
@Component
public class PersonajeServiceImpl implements PersonajeService{
	
	//Se inyecta a la clase la dependencia BitacoraRepository
	/**
	 * Inyeccion de dependencia
	 */
	@Autowired
	private BitacoraRepository bitacoraRepository;
	
	/**
	 * Metodo para obtener todos los personajes
	 */
	public Object getAllCharacters() {	
		int tipoOperacion = 1;
		Long id = null;
		Utils utils = new Utils();
		Object objectoRespuesta = new Object();
		
		//Se ejecuta el cliente JAR que consume los servicios API
		objectoRespuesta = utils.ejecutaCliente(tipoOperacion, id);
		tipoOperacion = 1;
		
		//Guardar en bitacora la consulta al servicio
		Bitacora registroBitacora = new Bitacora();
		registroBitacora = utils.objetoBitacora(tipoOperacion);
		bitacoraRepository.save(registroBitacora);
		
		return objectoRespuesta;
	}
	
	/**
	 * Metodo para obtener personaje por id
	 */
	public Object getCharacterById(Long id) {	
		int tipoOperacion = 2;
		Utils utils = new Utils();
		Object objectoRespuesta = new Object();
		
		//Se ejecuta el cliente JAR que consume los servicios API
		objectoRespuesta = utils.ejecutaCliente(tipoOperacion, id);
		
		//Guardar en bitacora la consulta al servicio
		Bitacora registroBitacora = new Bitacora();
		registroBitacora = utils.objetoBitacora(tipoOperacion);
		bitacoraRepository.save(registroBitacora);
		
		return objectoRespuesta;
	}
	
	/**
	 * Metodo para obtener todos los registros de bitacora
	 */
	public Object getBitacora() {
		return bitacoraRepository.findAll();
	}

}
