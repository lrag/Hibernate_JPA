package com.curso.modelo.entidad;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Pedido.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Pedido_ {

	public static final String FECHA = "fecha";
	public static final String CLIENTE = "cliente";
	public static final String CODIGO = "codigo";
	public static final String ID = "id";

	
	/**
	 * @see com.curso.modelo.entidad.Pedido#fecha
	 **/
	public static volatile SingularAttribute<Pedido, Date> fecha;
	
	/**
	 * @see com.curso.modelo.entidad.Pedido#cliente
	 **/
	public static volatile SingularAttribute<Pedido, Cliente> cliente;
	
	/**
	 * @see com.curso.modelo.entidad.Pedido#codigo
	 **/
	public static volatile SingularAttribute<Pedido, String> codigo;
	
	/**
	 * @see com.curso.modelo.entidad.Pedido#id
	 **/
	public static volatile SingularAttribute<Pedido, Integer> id;
	
	/**
	 * @see com.curso.modelo.entidad.Pedido
	 **/
	public static volatile EntityType<Pedido> class_;

}

