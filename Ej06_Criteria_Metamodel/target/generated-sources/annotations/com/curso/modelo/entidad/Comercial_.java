package com.curso.modelo.entidad;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Comercial.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Comercial_ {

	public static final String ID = "id";
	public static final String CLIENTES = "clientes";
	public static final String NOMBRE = "nombre";

	
	/**
	 * @see com.curso.modelo.entidad.Comercial#id
	 **/
	public static volatile SingularAttribute<Comercial, Integer> id;
	
	/**
	 * @see com.curso.modelo.entidad.Comercial#clientes
	 **/
	public static volatile ListAttribute<Comercial, Cliente> clientes;
	
	/**
	 * @see com.curso.modelo.entidad.Comercial
	 **/
	public static volatile EntityType<Comercial> class_;
	
	/**
	 * @see com.curso.modelo.entidad.Comercial#nombre
	 **/
	public static volatile SingularAttribute<Comercial, String> nombre;

}

