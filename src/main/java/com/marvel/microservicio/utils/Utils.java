package com.marvel.microservicio.utils;

import org.springframework.web.client.RestClient;
import com.marvel.microservicio.model.Personaje;

public class Utils {
	
	public Object ejecutaJAR1() {	
		RestClient restClient = RestClient.create();
		Object object = restClient.get()
				.uri("http://localhost:8081/public/marvel")
    			.retrieve() 
    			.body(Object.class);
		return object;
	}
	
	public Personaje ejecutaJAR2(Long id) {
		String uri = "http://localhost:8081/public/marvel/{id}";
		RestClient restClient = RestClient.create();
		return restClient.get() 
				.uri(uri, id)
				.retrieve() 
				.body(Personaje.class);	
	}

}
