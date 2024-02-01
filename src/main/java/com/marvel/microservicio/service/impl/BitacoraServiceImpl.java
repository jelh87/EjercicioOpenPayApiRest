package com.marvel.microservicio.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.marvel.microservicio.repository.BitacoraRepository;
import com.marvel.microservicio.service.BitacoraService;

//Para poder inyectarla como componente al Controller
/**
 * Clase que implementa la interfaz
 */
@Repository
public class BitacoraServiceImpl implements BitacoraService{

	/**
	 * Componente del logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(BitacoraServiceImpl.class);

	//Se inyecta a la clase la dependencia BitacoraRepository
	/**
	 * Inyeccion de dependencia
	 */
	@Autowired
	private BitacoraRepository bitacoraRepository;

	/**
	 * Metodo para obtener todos los registros de bitacora
	 */
	public Object getBitacora() {
		LOG.info("Ingresa al metodo getAllCharacters de la clase BitacoraServiceImpl.");
		return bitacoraRepository.findAll();
	}

}
