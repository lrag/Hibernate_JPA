package com.curso.modelo.entidad;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Factura {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String codigo;
	private LocalDate fecha;
	
	@ManyToOne
	@JoinColumn(name="fk_id_cliente", referencedColumnName="id")
	private Cliente cliente;
	
	@OneToMany(mappedBy="factura", cascade=CascadeType.ALL)
	private Set<DetalleFactura> detalles;

	public Factura() {
		super();
	}

	public Factura(Integer id, String codigo, LocalDate fecha) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fecha = fecha;
	}

	public Factura(Integer id, String codigo, LocalDate fecha, Cliente cliente, Set<DetalleFactura> detalles) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fecha = fecha;
		this.cliente = cliente;
		this.detalles = detalles;
	}

	public Factura(Integer id, String codigo, LocalDate fecha, Cliente cliente) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.fecha = fecha;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(Set<DetalleFactura> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Factura [id=" + id + ", codigo=" + codigo + ", fecha=" + fecha + ", cliente=" + cliente + "]";
	}

}

