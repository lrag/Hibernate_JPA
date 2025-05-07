package com.curso.modelo.entidad;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Cliente.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Cliente_ {

	public static final String DATOS_BANCARIOS = "datosBancarios";
	public static final String COMERCIALES = "comerciales";
	public static final String DIRECCION = "direccion";
	public static final String ID = "id";
	public static final String PEDIDOS = "pedidos";
	public static final String TELEFONO = "telefono";
	public static final String NOMBRE = "nombre";

	
	/**
	 * @see com.curso.modelo.entidad.Cliente#datosBancarios
	 **/
	public static volatile SingularAttribute<Cliente, DatosBancarios> datosBancarios;
	
	/**
	 * @see com.curso.modelo.entidad.Cliente#comerciales
	 **/
	public static volatile ListAttribute<Cliente, Comercial> comerciales;
	
	/**
	 * @see com.curso.modelo.entidad.Cliente#direccion
	 **/
	public static volatile SingularAttribute<Cliente, Direccion> direccion;
	
	/**
	 * @see com.curso.modelo.entidad.Cliente#id
	 **/
	public static volatile SingularAttribute<Cliente, Integer> id;
	
	/**
	 * @see com.curso.modelo.entidad.Cliente#pedidos
	 **/
	public static volatile ListAttribute<Cliente, Pedido> pedidos;
	
	/**
	 * @see com.curso.modelo.entidad.Cliente#telefono
	 **/
	public static volatile SingularAttribute<Cliente, String> telefono;
	
	/**
	 * @see com.curso.modelo.entidad.Cliente
	 **/
	public static volatile EntityType<Cliente> class_;
	
	/**
	 * @see com.curso.modelo.entidad.Cliente#nombre
	 **/
	public static volatile SingularAttribute<Cliente, String> nombre;

}

