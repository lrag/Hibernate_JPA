package com.curso.modelo.entidad;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Pelicula.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Pelicula_ {

	public static final String YEAR = "year";
	public static final String DIRECTOR = "director";
	public static final String GENERO = "genero";
	public static final String TITULO = "titulo";
	public static final String ID = "id";

	
	/**
	 * @see com.curso.modelo.entidad.Pelicula#year
	 **/
	public static volatile SingularAttribute<Pelicula, Integer> year;
	
	/**
	 * @see com.curso.modelo.entidad.Pelicula#director
	 **/
	public static volatile SingularAttribute<Pelicula, String> director;
	
	/**
	 * @see com.curso.modelo.entidad.Pelicula#genero
	 **/
	public static volatile SingularAttribute<Pelicula, String> genero;
	
	/**
	 * @see com.curso.modelo.entidad.Pelicula#titulo
	 **/
	public static volatile SingularAttribute<Pelicula, String> titulo;
	
	/**
	 * @see com.curso.modelo.entidad.Pelicula#id
	 **/
	public static volatile SingularAttribute<Pelicula, Integer> id;
	
	/**
	 * @see com.curso.modelo.entidad.Pelicula
	 **/
	public static volatile EntityType<Pelicula> class_;

}

