

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.Factura;

public class CargarDatos {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		
		EntityManager em = null;
		
		em = emf.createEntityManager();	
		em.getTransaction().begin();
		
		em.createQuery("delete from Cliente").executeUpdate();
		em.createQuery("delete from Factura").executeUpdate();
		
		Cliente c1 = new Cliente(null,"Bart",111L,true,new Date());
		Cliente c2 = new Cliente(null,"Bart",222L,true,new Date());
		Cliente c3 = new Cliente(null,"Bender",222L,false,new Date());
		Cliente c4 = new Cliente(null,"Groucho",333L,true,new Date());
		Cliente c5 = new Cliente(null,"John McClane",444L,false,new Date());
		Cliente c6 = new Cliente(null,"Mr. T",555L,true,new Date());
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		em.persist(c5);
		em.persist(c6);
		
		Factura f1 = new Factura(null,"FAC-1",10d,c1);
		Factura f2 = new Factura(null,"FAC-2",20d,c1);
		Factura f3 = new Factura(null,"FAC-3",30d,c1);
		Factura f4 = new Factura(null,"FAC-4",40d,c1);
		Factura f5 = new Factura(null,"FAC-5",50d,c1);
		em.persist(f1);
		em.persist(f2);
		em.persist(f3);
		em.persist(f4);
		em.persist(f5);		
		
		em.getTransaction().commit();		
		em.close();
	}
	
}
