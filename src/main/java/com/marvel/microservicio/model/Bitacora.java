package com.marvel.microservicio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad Bitacora
 */
@Entity
@Table(name="bitacoras")
public class Bitacora {
	
	/**
	 * Propiedad id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * Propiedad operacion
	 */
	private String operacion;
	
	/**
	 * Propiedad servicio
	 */
	private String servicio;
	
	/**
	 * Propiedad fecha
	 */
	private String fecha;
	
	/**
	 * Propiedad hora
	 */
	private String hora;
	
	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return operacion
	 */
	public String getOperacion() {
		return operacion;
	}
	
	/**
	 * @param operacion operacion
	 */
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	/**
	 * @return servicio
	 */
	public String getServicio() {
		return servicio;
	}
	
	/**
	 * @param servicio servicio
	 */
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	
	/**
	 * @return fecha
	 */
	public String getFecha() {
		return fecha;
	}
	
	/**
	 * @param fecha fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * @return hora
	 */
	public String getHora() {
		return hora;
	}
	
	/**
	 * @param hora hora
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}	

}
