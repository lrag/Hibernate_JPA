package com.curso.modelo.entidad;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(DatosBancarios.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class DatosBancarios_ {

	public static final String CLIENTE = "cliente";
	public static final String NUMERO_TC = "numeroTC";
	public static final String BANCO = "banco";
	public static final String ID = "id";

	
	/**
	 * @see com.curso.modelo.entidad.DatosBancarios#cliente
	 **/
	public static volatile SingularAttribute<DatosBancarios, Cliente> cliente;
	
	/**
	 * @see com.curso.modelo.entidad.DatosBancarios#numeroTC
	 **/
	public static volatile SingularAttribute<DatosBancarios, Integer> numeroTC;
	
	/**
	 * @see com.curso.modelo.entidad.DatosBancarios#banco
	 **/
	public static volatile SingularAttribute<DatosBancarios, String> banco;
	
	/**
	 * @see com.curso.modelo.entidad.DatosBancarios#id
	 **/
	public static volatile SingularAttribute<DatosBancarios, Integer> id;
	
	/**
	 * @see com.curso.modelo.entidad.DatosBancarios
	 **/
	public static volatile EntityType<DatosBancarios> class_;

}

