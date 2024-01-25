package com.marvel.microservicio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.marvel.microservicio.filters.JwtRequestFilter;
import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Clase WebSecurityConfig para la 
 * configuracion de las peticiones a la API Rest
 */
@Configuration
public class WebSecurityConfig {

	/**
	 * Inyeccion de dependencia del filtro
	 */
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	/**
	 * Metodo para definir el filtro
	 * @param http peticion segura
	 * @return http peticion segura
	 * @throws Exception Manejo de la excepcion
	 */
	@Bean
	SecurityFilterChain web(HttpSecurity http) throws Exception {
		http
		.csrf().disable() // (2)
		.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers("/api/personajes/**").permitAll()
				.anyRequest().authenticated()
				)
		.cors(withDefaults())
		.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
		.sessionManagement((session) -> session
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				);
		;
		/*
    http
        .formLogin(withDefaults()); // (1)
    http
        .httpBasic(withDefaults()); // (1)
		 */
		return http.build();
	}
	/* (1) By default, Spring Security form login/http basic auth are enabled.
  However, as soon as any servlet-based configuration is provided,
  form based login or/and http basic auth must be explicitly provided.

	 * (2) If our stateless API uses token-based authentication, such as JWT,
    we don't need CSRF protection
	 */

	/**
	 * Metodo que encodifica el password
	 * @return password encodificado
	 */
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Metodo para la autenticacion
	 * @param authenticationConfiguration configuracion
	 * @return authenticationManager authenticationManager 
	 * @throws Exception Manejo de la excepcion
	 */
	@Bean
	AuthenticationManager authenticationManager(AuthenticationConfiguration
			authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

}
