package com.curso.modelo.persistencia.utl;

import static org.hibernate.cfg.JdbcSettings.FORMAT_SQL;
import static org.hibernate.cfg.JdbcSettings.HIGHLIGHT_SQL;
import static org.hibernate.cfg.JdbcSettings.SHOW_SQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.DetalleFactura;
import com.curso.modelo.entidad.Factura;
import com.curso.modelo.entidad.Visita;

import jakarta.persistence.EntityManager;

public class HibernateUtil {

	private static SessionFactory sf;
	
	private synchronized static SessionFactory getSF() {
		if(sf==null) {
			sf = new Configuration()
	                .addAnnotatedClass(Cliente.class)
	                .addAnnotatedClass(DetalleFactura.class)
	                .addAnnotatedClass(Factura.class)
	                .addAnnotatedClass(Visita.class)
	                .setProperty("jakarta.persistence.jdbc.url", "jdbc:h2:file:C:/H2/hibernate6_Bis")
	                .setProperty("jakarta.persistence.jdbc.user", "sa")
	                .setProperty("jakarta.persistence.jdbc.password", "")
	                .setProperty(SHOW_SQL, true)
	                .setProperty(FORMAT_SQL, false)
	                .setProperty(HIGHLIGHT_SQL, true)
	                .setProperty("hibernate.hbm2ddl.auto", "update")
	                .buildSessionFactory();
		}
		return sf;
	}
	
	public static SessionFactory getSessionFactory() {
		return getSF();
	}
	
	public static Session getSession() {
		return getSF().openSession();
	}
	
	public static Session getCurrentSession() {
		return getSF().getCurrentSession();
	}
	
	public static EntityManager getEntityManager() {
		return getSF().createEntityManager();
	}

	public static void closeSessionFactory() {
		if(sf!=null) {
			sf.close();
		}		
	}
	
}
