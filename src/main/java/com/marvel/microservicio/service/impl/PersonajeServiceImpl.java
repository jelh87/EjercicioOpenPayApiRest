package com.marvel.microservicio.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.marvel.microservicio.model.Bitacora;
import com.marvel.microservicio.model.Personaje;
import com.marvel.microservicio.repository.BitacoraRepository;
import com.marvel.microservicio.service.PersonajeService;
import com.marvel.microservicio.utils.Utils;

//Para poder inyectarla como componente al Controller
@Component
public class PersonajeServiceImpl implements PersonajeService{
	
	//Se inyecta a la clase la dependencia BitacoraRepository
	@Autowired
	private BitacoraRepository bitacoraRepository;
	
	public Object getAllCharacters() {		
		Utils utils = new Utils();
		Object object = new Object();
		object = utils.ejecutaJAR1();
		
		//Guardar en bitacora la consulta al servicio
		Bitacora registroBitacora = new Bitacora();
		registroBitacora.setOperacion("CONSULTA");
		registroBitacora.setServicio("CONSULTA TODOS LOS PERSONAJES");
		Date date = new Date();
		registroBitacora.setFecha(date.toString());
		registroBitacora.setHora(date.toString());
		bitacoraRepository.save(registroBitacora);
		
		return object;
	}
	
	public Personaje getCharacterById(Long id) {		
		Utils utils = new Utils();
		Personaje personaje = utils.ejecutaJAR2(id);
		
		//Guardar en bitacora la consulta al servicio
		Bitacora registroBitacora = new Bitacora();
		registroBitacora.setOperacion("CONSULTA");
		registroBitacora.setServicio("CONSULTA PERSONAJE POR ID: " + id);
		Date date = new Date();
		registroBitacora.setFecha(date.toString());
		registroBitacora.setHora(date.toString());
		bitacoraRepository.save(registroBitacora);
		
		return personaje;
	}
	
	public List<Bitacora> getBitacora() {
		return bitacoraRepository.findAll();
	}

}
