package com.curso.modelo.entidad;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Software_Joined.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Software_Joined_ extends com.curso.modelo.entidad.Producto_Joined_ {

	public static final String TECNOLOGIA = "tecnologia";

	
	/**
	 * @see com.curso.modelo.entidad.Software_Joined#tecnologia
	 **/
	public static volatile SingularAttribute<Software_Joined, String> tecnologia;
	
	/**
	 * @see com.curso.modelo.entidad.Software_Joined
	 **/
	public static volatile EntityType<Software_Joined> class_;

}

