package com.curso.modelo.entidad;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Consultoria_Joined.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Consultoria_Joined_ extends com.curso.modelo.entidad.Producto_Joined_ {

	public static final String PRECIO_POR_CABEZA = "precioPorCabeza";

	
	/**
	 * @see com.curso.modelo.entidad.Consultoria_Joined#precioPorCabeza
	 **/
	public static volatile SingularAttribute<Consultoria_Joined, Integer> precioPorCabeza;
	
	/**
	 * @see com.curso.modelo.entidad.Consultoria_Joined
	 **/
	public static volatile EntityType<Consultoria_Joined> class_;

}

