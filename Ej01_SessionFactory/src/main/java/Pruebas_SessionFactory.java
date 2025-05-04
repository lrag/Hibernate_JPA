

import static org.hibernate.cfg.JdbcSettings.FORMAT_SQL;
import static org.hibernate.cfg.JdbcSettings.HIGHLIGHT_SQL;
import static org.hibernate.cfg.JdbcSettings.PASS;
import static org.hibernate.cfg.JdbcSettings.SHOW_SQL;
import static org.hibernate.cfg.JdbcSettings.URL;
import static org.hibernate.cfg.JdbcSettings.USER;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.curso.modelo.entidad.Pelicula;

public class Pruebas_SessionFactory {

	public static void main(String[] args) {

		//
		//Hibernate3
		//
		/*
		SessionFactory sf = new Configuration().
				                configure("cfg/hibernate.cfg.xml").
				                buildSessionFactory();
		*/

		//
		//Hibernate 4
		//
		/*
		Configuration configuration = new Configuration();
	    configuration.configure("cfg/hibernate.cfg.xml");
	    ServiceRegistry serviceRegistry =
			new ServiceRegistryBuilder().
				applySettings(configuration.getProperties()).
					buildServiceRegistry();
	    SessionFactory sf = configuration.buildSessionFactory(serviceRegistry);
	    */

		//
		//Hibernate 4.3 (xml)
		//
		/*
		StandardServiceRegistry standardRegistry =
			new StandardServiceRegistryBuilder().
				configure("cfg/hibernate.cfg.xml").build();
		Metadata metaData =
	        new MetadataSources(standardRegistry).
	        	getMetadataBuilder().
	        		build();
		SessionFactory sf = metaData.getSessionFactoryBuilder().build();
		*/

		//
		//Hibernate 5
		//
		/*
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
		sources.addAnnotatedClass(Pelicula.class);
		sources.addPackage("com.curso.modelo.entidad");

		SessionFactory sf = sources.getMetadataBuilder().build().buildSessionFactory();

	    sf.close();
	    */
		
		//
		//Hibernate 6
		//
		SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Pelicula.class)
                .setProperty(URL, "jdbc:h2:file:C:/H2/hibernate6")
                .setProperty(USER, "sa")
                .setProperty(PASS, "")
                .setProperty(SHOW_SQL, true)
                .setProperty(FORMAT_SQL, false)
                .setProperty(HIGHLIGHT_SQL, true)
                .buildSessionFactory();
		
		sessionFactory.close();

	}

}
