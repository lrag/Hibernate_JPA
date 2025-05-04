

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Pruebas_EntityManagerFactory {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("H2PU");
		
		emf.close();

	}

}
