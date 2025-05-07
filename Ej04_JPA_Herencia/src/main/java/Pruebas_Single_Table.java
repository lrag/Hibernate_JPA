import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import modelo_single_table.Consultoria_Single_Table;
import modelo_single_table.Hardware_Single_Table;
import modelo_single_table.Producto_Single_Table;
import modelo_single_table.Software_Single_Table;


public class Pruebas_Single_Table {

	public static void main(String[] args) {
		
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppPU_Herencia_SINGLE_TABLE");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("H2PU");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Producto_Single_Table p = new Producto_Single_Table(0,"Producto","Es una cosa abstracta");
		Hardware_Single_Table hw = new Hardware_Single_Table(0,"Servidor","GORDÍSIMO",40d);
		Software_Single_Table sw = new Software_Single_Table(0,"Aplicacion", "Estupenda","Spring MVC + Hibernate");
		Consultoria_Single_Table co = new Consultoria_Single_Table(0,"Consultoria","Muchachos",100);

		em.persist(p);
		em.persist(hw);
		em.persist(sw);
		em.persist(co);
		
		/*
		Hardware_Single_Table x = new Hardware_Single_Table(0, "teclado", "teclado estupendo", 3);
		em.persist(x); //33
		
		Producto_Single_Table y = em.find(Producto_Single_Table.class, 33);
		*/

		em.getTransaction().commit();
		em.close();
		
		emf.close();
		
	}
	
}
