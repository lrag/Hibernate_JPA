package com.curso.modelo.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalle_factura")
public class DetalleFactura {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Double cantidad;
	private Double precio;
	private String producto;

	@ManyToOne
	@JoinColumn(name="fk_id_factura", referencedColumnName="id")
	private Factura factura;

	public DetalleFactura() {
		super();
	}

	public DetalleFactura(Integer id, Double cantidad, Double precio, String producto, Factura factura) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.precio = precio;
		this.producto = producto;
		this.factura = factura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "DetalleFactura [id=" + id + ", cantidad=" + cantidad + ", precio=" + precio + ", producto=" + producto
				+ "]";
	}

}
