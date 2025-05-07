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

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nombre;
	private Long telefono;

	private Boolean activo;

	@Column(name = "fecha_alta")
	@Temporal(TemporalType.DATE)
	private Date fechaAlta;

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nombre, Long telefono, Boolean activo, Date fechaAlta) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.activo = activo;
		this.fechaAlta = fechaAlta;
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

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", activo=" + activo
				+ ", fechaAlta=" + fechaAlta + "]";
	}

	
}
