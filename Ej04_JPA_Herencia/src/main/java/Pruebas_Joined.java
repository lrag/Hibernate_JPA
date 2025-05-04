import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo_joined.Consultoria_Joined;
import modelo_joined.Hardware_Joined;
import modelo_joined.Producto_Joined;
import modelo_joined.Software_Joined;


public class Pruebas_Joined {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("H2PU");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Producto_Joined p = new Producto_Joined(0,"Producto","Es una cosa abstracta");
		Hardware_Joined hw = new Hardware_Joined(0,"Servidor","GORDÍSIMO",40);
		Software_Joined sw = new Software_Joined(0,"Aplicacion", "Estupenda","Spring MVC + Hibernate");
		Consultoria_Joined co = new Consultoria_Joined(0,"Consultoria","Muchachos",100);

		em.persist(p);
		em.persist(hw);
		em.persist(sw);
		em.persist(co);
		
		em.getTransaction().commit();
		em.close();
		
		emf.close();
		
	}
	
}
