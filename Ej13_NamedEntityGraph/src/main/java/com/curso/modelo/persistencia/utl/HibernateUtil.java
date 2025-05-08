package com.curso.modelo.persistencia.utl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.DetalleFactura;
import com.curso.modelo.entidad.Factura;

public class HibernateUtil {

	private static SessionFactory sf;
	
	private static SessionFactory getSF() {
		if(sf==null) {
	        Map<String, String> settings = new HashMap<>();
	        settings.put(Environment.DRIVER, "org.h2.Driver");
	        settings.put(Environment.URL, "jdbc:h2:file:C:/H2/curso");
	        settings.put(Environment.USER, "sa");
	        settings.put(Environment.PASS, "");
	        settings.put(Environment.DIALECT, "org.hibernate.dialect.H2Dialect");	
	        settings.put(Environment.HBM2DDL_AUTO, "update");
	        settings.put(Environment.SHOW_SQL, "true");
			
			StandardServiceRegistry standardRegistry =
					new StandardServiceRegistryBuilder().applySettings(settings).build();
			MetadataSources sources = new MetadataSources( standardRegistry );
			sources.addAnnotatedClass(Cliente.class);
			sources.addAnnotatedClass(Factura.class);
			sources.addAnnotatedClass(DetalleFactura.class);
			
			sf = sources.getMetadataBuilder().build().buildSessionFactory();		
		}
		return sf;
	}
	
	public static SessionFactory getSessionFactory() {
		return getSF();
	}
	
	public static Session getSession() {
		return getSF().openSession();
	}

	public static void closeSessionFactory() {
		if(sf!=null) {
			sf.close();
		}
		
	}
	
}
