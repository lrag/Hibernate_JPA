package com.curso.modelo.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

public class ClienteDTO {
	
	private Integer id;
	private String nombre;
	private Long telefono;

	public ClienteDTO() {
		super();
		System.out.println("ClienteDTO()");
	}
	
	public ClienteDTO(Integer id, String nombre, Long telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		System.out.println("ClienteDTO(id,nombre,telefono)");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "ClienteDTO [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + "]";
	}

}
