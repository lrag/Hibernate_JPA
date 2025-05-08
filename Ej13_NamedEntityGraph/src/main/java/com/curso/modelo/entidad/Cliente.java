package com.curso.modelo.entidad;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;

@Entity

@NamedEntityGraph(
	name = "ClienteConFacturas", 
	attributeNodes = {
			@NamedAttributeNode("facturas")
	}
)

@NamedEntityGraph(
	name = "ClienteConFacturasYDetalles", 
	attributeNodes = {
		@NamedAttributeNode(value="facturas", subgraph="DetallesFactura") //<----
	},
	subgraphs = {
        @NamedSubgraph(
                name = "DetallesFactura",
                attributeNodes = {
                    @NamedAttributeNode("detalles")
                }
        )
    }
)
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String direccion;
	private String telefono;

	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
	private Set<Factura> facturas;

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nombre, String direccion, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Set<Factura> facturas) {
		this.facturas = facturas;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}

}
