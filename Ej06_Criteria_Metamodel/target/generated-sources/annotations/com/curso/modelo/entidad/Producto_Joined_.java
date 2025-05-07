package com.curso.modelo.entidad;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Producto_Joined.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Producto_Joined_ {

	public static final String DESCRIPCION = "descripcion";
	public static final String EXISTENCIAS = "existencias";
	public static final String ID_PRODUCTO = "idProducto";
	public static final String NOMBRE = "nombre";

	
	/**
	 * @see com.curso.modelo.entidad.Producto_Joined#descripcion
	 **/
	public static volatile SingularAttribute<Producto_Joined, String> descripcion;
	
	/**
	 * @see com.curso.modelo.entidad.Producto_Joined#existencias
	 **/
	public static volatile SingularAttribute<Producto_Joined, Integer> existencias;
	
	/**
	 * @see com.curso.modelo.entidad.Producto_Joined#idProducto
	 **/
	public static volatile SingularAttribute<Producto_Joined, Integer> idProducto;
	
	/**
	 * @see com.curso.modelo.entidad.Producto_Joined
	 **/
	public static volatile EntityType<Producto_Joined> class_;
	
	/**
	 * @see com.curso.modelo.entidad.Producto_Joined#nombre
	 **/
	public static volatile SingularAttribute<Producto_Joined, String> nombre;

}

