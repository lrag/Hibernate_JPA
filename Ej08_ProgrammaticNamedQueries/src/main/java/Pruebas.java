import static org.hibernate.cfg.JdbcSettings.FORMAT_SQL;
import static org.hibernate.cfg.JdbcSettings.HIGHLIGHT_SQL;
import static org.hibernate.cfg.JdbcSettings.SHOW_SQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.curso.modelo.entidad.Pelicula;

import jakarta.persistence.Query;

public class Pruebas {

	//@SuppressWarnings("unchecked")
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Pelicula.class)
                .setProperty("jakarta.persistence.jdbc.url", "jdbc:h2:file:C:/H2/hibernate6")
                .setProperty("jakarta.persistence.jdbc.user", "sa")
                .setProperty("jakarta.persistence.jdbc.password", "")
                .setProperty(SHOW_SQL, true)
                .setProperty(FORMAT_SQL, false)
                .setProperty(HIGHLIGHT_SQL, true)
                .setProperty("hibernate.hbm2ddl.auto", "update")
                .buildSessionFactory();

		Session s = sessionFactory.openSession();
		//
		Query q = s.createQuery("select p from Pelicula p where p.genero=:genero", Pelicula.class); 
		s.getSessionFactory().addNamedQuery("pelicula.listarPorGenero", q);
	    s.close();

	    s = sessionFactory.openSession();
	    
	    s.createNamedQuery("pelicula.listarPorGenero", Pelicula.class)
	    	.setParameter("genero", "Acción")
	    	.getResultList()
	    	.forEach( p -> System.out.println(p));
	    
	    
	    s.close();
	    
	    sessionFactory.close();

	    
	}
	
}
