package com.marvel.microservicio.service.impl;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * Clase JwtUtilService
 */
@Service
public class JwtUtilService {
	
	// LLAVE_MUY_SECRETA => [Base64] => TExBVkVfTVVZX1NFQ1JFVEE=
	/**
	 * Constante JWT_SECRET_KEY
	 */
	private static final String JWT_SECRET_KEY = "TExBVkVfTVVZX1NFQ1JFVEE=";

	/**
	 * Constante JWT_TOKEN_VALIDITY
	 */
	public static final long JWT_TOKEN_VALIDITY = 1000 * 60 * 60 * (long) 8; // 8 Horas

	/**
	 * @param token token
	 * @return seteo de propiedad
	 */
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

	/**
	 * @param token token
	 * @return seteo de propiedad
	 */
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	/**
	 * Propiedades del JWT
	 * @param <T> T
	 * @param token token claimsResolver
	 * @param claimsResolver
	 * @return seteo de propiedad
	 */
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		return claimsResolver.apply(extractAllClaims(token));
	}

	/**
	 * Propiedades del JWT
	 * @param token token
	 * @return seteo de propiedad
	 */
	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(JWT_SECRET_KEY).parseClaimsJws(token).getBody();
	}

	/**
	 * Propiedades del JWT
	 * @param token token
	 * @return seteo de propiedad
	 */
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	/**
	 * Propiedades del JWT
	 * @param userDetails userDetails
	 * @return seteo de propiedad
	 */
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		// Agregando informacion adicional como "claim"
		var rol = userDetails.getAuthorities().stream().collect(Collectors.toList()).get(0);
		claims.put("rol", rol);
		return createToken(claims, userDetails.getUsername());
	}

	/**
	 * Generacion del JWT
	 * @param claims claims
	 * @param subject subject
	 * @return JWT
	 */
	private String createToken(Map<String, Object> claims, String subject) {

		return Jwts
				.builder()
				.setClaims(claims)
				.setSubject(subject)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
				.signWith(SignatureAlgorithm.HS256, JWT_SECRET_KEY)
				.compact();
	}

	/**
	 * Validacion del JWT
	 * @param token token
	 * @param userDetails userDetails
	 * @return respuesta de la validacion
	 */
	public boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
