package com.curso.modelo.entidad;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Pedido2.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Pedido2_ {

	public static final String FECHA = "fecha";
	public static final String CLIENTE = "cliente";
	public static final String CODIGO = "codigo";
	public static final String ID = "id";

	
	/**
	 * @see com.curso.modelo.entidad.Pedido2#fecha
	 **/
	public static volatile SingularAttribute<Pedido2, Date> fecha;
	
	/**
	 * @see com.curso.modelo.entidad.Pedido2#cliente
	 **/
	public static volatile SingularAttribute<Pedido2, Cliente> cliente;
	
	/**
	 * @see com.curso.modelo.entidad.Pedido2#codigo
	 **/
	public static volatile SingularAttribute<Pedido2, String> codigo;
	
	/**
	 * @see com.curso.modelo.entidad.Pedido2#id
	 **/
	public static volatile SingularAttribute<Pedido2, Integer> id;
	
	/**
	 * @see com.curso.modelo.entidad.Pedido2
	 **/
	public static volatile EntityType<Pedido2> class_;

}

