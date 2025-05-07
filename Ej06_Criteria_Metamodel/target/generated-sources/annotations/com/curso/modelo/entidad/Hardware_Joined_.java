package com.curso.modelo.entidad;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Hardware_Joined.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Hardware_Joined_ extends com.curso.modelo.entidad.Producto_Joined_ {

	public static final String PESO = "peso";

	
	/**
	 * @see com.curso.modelo.entidad.Hardware_Joined#peso
	 **/
	public static volatile SingularAttribute<Hardware_Joined, Double> peso;
	
	/**
	 * @see com.curso.modelo.entidad.Hardware_Joined
	 **/
	public static volatile EntityType<Hardware_Joined> class_;

}

