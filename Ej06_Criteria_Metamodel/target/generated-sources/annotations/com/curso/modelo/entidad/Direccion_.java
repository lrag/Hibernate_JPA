package com.curso.modelo.entidad;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EmbeddableType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Direccion.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Direccion_ {

	public static final String NUMERO = "numero";
	public static final String CODIGO_POSTAL = "codigoPostal";
	public static final String CIUDAD = "ciudad";
	public static final String CALLE = "calle";

	
	/**
	 * @see com.curso.modelo.entidad.Direccion#numero
	 **/
	public static volatile SingularAttribute<Direccion, String> numero;
	
	/**
	 * @see com.curso.modelo.entidad.Direccion#codigoPostal
	 **/
	public static volatile SingularAttribute<Direccion, String> codigoPostal;
	
	/**
	 * @see com.curso.modelo.entidad.Direccion#ciudad
	 **/
	public static volatile SingularAttribute<Direccion, String> ciudad;
	
	/**
	 * @see com.curso.modelo.entidad.Direccion#calle
	 **/
	public static volatile SingularAttribute<Direccion, String> calle;
	
	/**
	 * @see com.curso.modelo.entidad.Direccion
	 **/
	public static volatile EmbeddableType<Direccion> class_;

}

