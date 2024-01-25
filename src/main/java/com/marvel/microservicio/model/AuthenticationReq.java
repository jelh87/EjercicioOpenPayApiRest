package com.marvel.microservicio.model;

import java.io.Serializable;

/**
 * Clase Bean AuthenticationReq
 */
public class AuthenticationReq implements Serializable {

	/**
	 * Serializacion
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * usuario
	 */
	private String usuario;

	/**
	 * clave
	 */
	private String clave;

	/**
	 * @param usuario usuario
	 * @param clave clave
	 */
	public AuthenticationReq(String usuario, String clave) {
		this.usuario = usuario;
		this.clave = clave;
	}

	/**
	 * @return usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param username username
	 */
	public void setUsuario(String username) {
		this.usuario = usuario;
	}

	/**
	 * @return clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave clave
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}
}
