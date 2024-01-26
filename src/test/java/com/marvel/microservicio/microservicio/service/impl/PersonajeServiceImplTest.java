package com.marvel.microservicio.microservicio.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.marvel.microservicio.repository.BitacoraRepository;
import com.marvel.microservicio.service.impl.PersonajeServiceImpl;

/**
 * Clase test de la clase PersonajeServiceImplTest
 */
@ExtendWith(MockitoExtension.class)
public class PersonajeServiceImplTest {
	
	/**
	 * Inyeccion
	 */
	@Mock
	private BitacoraRepository bitacoraRepository;
	
	/**
	 * Instancia
	 */
	@InjectMocks
	private PersonajeServiceImpl personajeServiceImpl;
	
	/**
	 * resultadoAll
	 */
	private Object resultadoAll;
	
	/**
	 * resultadoOne
	 */
	private Object resultadoOne;
	
	/**
	 * noEsperado
	 */
	private Object noEsperado;
	
	/**
	 * id
	 */
	private Long id = 1011334L;
	
	/**
	 * Metodo setup ejecuciones previas a los Test
	 */
	@BeforeEach
    public void setup(){
		resultadoAll = personajeServiceImpl.getAllCharacters();
		resultadoOne = personajeServiceImpl.getCharacterById(id);
    }
	
	/**
	 * Test del metodo getAllCharacters
	 */
	@DisplayName("JUnit test metodo getAllCharacters")
	@Test
	void testGetAllCharacters() {
		final Object esperado = personajeServiceImpl.getAllCharacters();
		Assertions.assertNotNull(esperado);
		Assertions.assertEquals(resultadoAll, esperado);
		Assertions.assertNotEquals(resultadoOne, esperado);
		Assertions.assertNotSame(noEsperado, esperado);
	}
	
	/**
	 * Test del metodo getCharacterById
	 */
	@DisplayName("JUnit test metodo getCharacterById")
	@Test
	void testGetCharacterById() {
		final Object esperado = personajeServiceImpl.getCharacterById(id);
		Assertions.assertNotNull(esperado);
		Assertions.assertEquals(resultadoOne, esperado);
		Assertions.assertNotEquals(resultadoAll, esperado);
		Assertions.assertNotSame(noEsperado, esperado);
	}

}
