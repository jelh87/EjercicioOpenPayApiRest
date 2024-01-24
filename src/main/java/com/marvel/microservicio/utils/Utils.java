package com.marvel.microservicio.utils;

import java.util.Date;

import org.springframework.web.client.RestClient;
import com.marvel.microservicio.model.Bitacora;

public class Utils {
	
	public Object ejecutaCliente(int tipoOperacion, Long id) {	
		RestClient restClient = RestClient.create();
		Object objetoRespuesta = new Object();
		
		if(tipoOperacion==1) {
			objetoRespuesta = restClient.get()
					.uri("http://localhost:8081/public/marvel")
	    			.retrieve() 
	    			.body(Object.class);
		}else if(tipoOperacion==2) {
			objetoRespuesta = restClient.get()
					.uri("http://localhost:8081/public/marvel/{id}", id)
	    			.retrieve() 
	    			.body(Object.class);
		}
		
		return objetoRespuesta;
	}
	
	public Bitacora objetoBitacora(int tipoOperacion) {
		Bitacora registroBitacora = new Bitacora();
		Date fecha = new Date();
		
		if(tipoOperacion==1) {
			registroBitacora.setOperacion("CONSULTA TODOS LOS PERSONAJES");
			registroBitacora.setServicio("GET /v1/public/characters");
			registroBitacora.setFecha(fecha.toString());
			registroBitacora.setHora(fecha.toString());
		}else if(tipoOperacion==2) {
			registroBitacora.setOperacion("CONSULTA PERSONAJE POR ID");
			registroBitacora.setServicio("GET /v1/public/characters/{characterId}");
			registroBitacora.setFecha(fecha.toString());
			registroBitacora.setHora(fecha.toString());
		}
		
		return registroBitacora;
	}

}
