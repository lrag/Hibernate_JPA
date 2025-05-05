import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.curso.modelo.entidad.Pelicula;

public class PruebasSession {

	public static void main(String[] args) {

		
		SessionFactory sf = null;		
		Session s = null;
		
		//INSERT
		System.out.println("==========================================");
		s = sf.openSession();
		//s.getTransaction().begin();
		s.beginTransaction();
		
		Pelicula p1 = new Pelicula(null, "Alien", "RS", "Susto", 1979);
		//Integer id = (Integer) s.save(p1); //HIB
		System.out.println(p1.getId());
		//Tambien tenemos el persist de JPA
		//s.persist(p1); //void
		s.getTransaction().commit(); //.rollback()
		s.close();
		
		//UPDATE CON TODOS LOS CAMPOS
		System.out.println("==========================================");
		s = sf.openSession();
		s.beginTransaction();

		/*
		Pelicula p = new Pelicula();
		p.setId(1);
		p.setDirector("Ridley Scott");
		s.update(p); //Update (y merge) hacen modificaciones a toda la tabla asi que perderiamos el resto de columnas
		*/

		//Pelicula p2 = new Pelicula(1, "Alien---", "Ridley Scott", "Mucho Susto", 1979);
		//s.merge(p2);
		
		s.getTransaction().commit(); //.rollback()
		s.close();

		//SELECT POR ID
		System.out.println("==========================================");
		s = sf.openSession();

		//Cach� de primer nivel, solo ejecuta el primer select,
		//guarda el objeto en la cach� y lo reutiliza
		Pelicula p3a = s.get(Pelicula.class, 1);
		Pelicula p3b = s.load(Pelicula.class, 1);
		System.out.println(p3b.getTitulo());
		Pelicula p3c = s.find(Pelicula.class, 1); //JPA
		
		p3a.setTitulo("Don erre que erre");
		System.out.println(p3c.getTitulo());
		s.close();
		
		//UPDATE CUANDO NO TENEMOS TODOS LOS DATOS
		System.out.println("==========================================");
		s = sf.openSession();
		s.beginTransaction();

		Integer id = 1;
		String director = "Richard Donner";

		Pelicula p4 = s.get(Pelicula.class, 1);
		p4.setDirector(director);
		//s.merge(p4);
		s.getTransaction().commit();
		s.close();
		
		//DELETE
		System.out.println("==========================================");
		s = sf.openSession();
		s.beginTransaction();

		Pelicula p5 = new Pelicula();
		p5.setId(4);
		//s.delete(p5); //Esto borra la pelicula si el id es correcto. si el id no es correcto: excepci�n

		s.getTransaction().commit();
		s.close();
		

		/*
		//OTROS METODOS
		s.evict(object);
		s.flush(); //Ejecuta cualquier consulta que estuviera pendiente
		s.clear(); //Vac�a la cach� de primer nivel
		s.refresh(object);
		*/
		
		//
		//sf.openStatelessSession();
		StatelessSession ss = sf.openStatelessSession();
		ss.beginTransaction();

		//ss.insert(entityName, entity)
		//ss.update(entity);
		//ss.delete(entity);
		//ss.get(entityClass, id);
				
		ss.getTransaction().commit();
		
		sf.close();
		
		
	}
	
}
















