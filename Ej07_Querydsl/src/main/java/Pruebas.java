

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.ClienteDTO;
import com.curso.modelo.entidad.QCliente;
import com.curso.modelo.entidad.QFactura;
import com.mysema.query.Tuple;
import com.mysema.query.jpa.impl.JPADeleteClause;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.jpa.impl.JPAUpdateClause;
import com.mysema.query.types.Projections;

public class Pruebas {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysqlPU");
		
		EntityManager em = null;
		
		em = emf.createEntityManager();	
		
		
		QCliente cliente = QCliente.cliente;
		
		//Todos
		//select c from Cliente c
		System.out.println("==================================================");
		JPAQuery query = new JPAQuery(em);
		List<Cliente> rs1 = query.from(cliente).
				 			      list(cliente);
		for(Cliente c: rs1){
			System.out.println(c);
		}

		//Una columna
		//select c.nombre from Cliente c
		System.out.println("==================================================");
		//Con JPQL las consultas no están tipadas.
		//Esto compila pero es zasca en runtime:
		//List<Factura> fostion = em.createQuery("select c.nombre from Cliente c").getResultList();

		query = new JPAQuery(em);
		List<String> rs1b = query.from(cliente).
				                  list(cliente.nombre);
		for(String c: rs1b){
			System.out.println(c);
		}
		
		//Varias columnas
		//select c.nombre, c.telefono from Cliente c
		System.out.println("==================================================");
		query = new JPAQuery(em);
		List<Tuple> rs1c = query.from(cliente).
				                 list(cliente.nombre, cliente.telefono);
		for(Tuple t: rs1c){
			System.out.println(t.get(cliente.nombre)+","+t.get(cliente.telefono));
		}

		//'DTO'
		System.out.println("==================================================");
		query = new JPAQuery(em);
		List<ClienteDTO> rs1d = query.from(cliente).
				                      list(Projections.bean(ClienteDTO.class, cliente.id, cliente.nombre, cliente.telefono));
		for(ClienteDTO dto: rs1d){
			System.out.println(dto);
		}		
		
		
		//Where
		System.out.println("==================================================");
		query = new JPAQuery(em);
		List<Cliente> rs2 = query.from(cliente).
				                  where(cliente.nombre.eq("Bart")).
				                  list(cliente);
		for(Cliente c: rs2){
			System.out.println(c);
		}
				
		//And
		System.out.println("==================================================");
		query = new JPAQuery(em);
		List<Cliente> rs3 = query.from(cliente).
				                  where(cliente.nombre.eq("Bart").and(cliente.telefono.eq(111L))).
				                  list(cliente);
		for(Cliente c: rs3){
			System.out.println(c);
		}
		
		//Or
		System.out.println("==================================================");
		query = new JPAQuery(em);
		List<Cliente> rs4 = query.from(cliente).
				                  where(cliente.nombre.eq("Bart").or(cliente.telefono.eq(333L))    ).
				                  list(cliente);
		for(Cliente c: rs4){
			System.out.println(c);
		}
		
		//Order by
		System.out.println("==================================================");
		query = new JPAQuery(em);
		List<Cliente> rs5 = query.from(cliente).
				                  where(cliente.telefono.gt(0)).
				                  orderBy(cliente.nombre.desc()).
				                  list(cliente);
		for(Cliente c: rs5){
			System.out.println(c);
		}

		//Agregaciones
		System.out.println("==================================================");
		query = new JPAQuery(em);
		Long sum = query.from(cliente).
				         list(cliente.telefono.sum()).get(0);
		System.out.println(sum);
		query = new JPAQuery(em);
		Long sum2 = query.from(cliente).
				          list(cliente.telefono.sum().add(100).multiply(2)).get(0);
		System.out.println(sum2);

		//Group by
		System.out.println("==================================================");
		query = new JPAQuery(em);		
		QFactura factura = QFactura.factura;
		List<Tuple> rs6 = query.from(factura).
								//join
			                    groupBy(factura.cliente.id).
			                    list(factura.cliente.nombre, factura.id.count());
		for(Tuple t:rs6){
			System.out.println(t.get(factura.cliente.nombre)+","+t.get(1, Integer.class));
		}
				
		//Group by
		//select sum(f.total), c.id from facturas f
		//join clientes c on c.id=f.fk_id_cliente
		//group by c.id	
		//
		//select sum(f.total), f.cliente.nombre from Factura f groupby f.cliente.id
		System.out.println("==================================================");
		query = new JPAQuery(em);

		//Bien, sin join (pero pedimos solo el id del cliente)
		//List<Tuple> rs7 = query.from(factura).
		//		                groupBy(factura.cliente.id).
		//		                list(factura.cliente.id, factura.total.sum());

		//Si pedimos algo que no esté en la tabla facturas ya es preciso el join
		//y sin pedirlo explicitamente no lo incluye!!!
		//WTF
		//List<Tuple> rs7 = query.from(factura).
		//		                groupBy(factura.cliente.id).
		//		                list(factura.cliente.nombre, factura.total.sum());

		
		//select f from Factura f where f.cliente.id=1
		List<Tuple> rs7 = query.from(factura).
							    innerJoin(factura.cliente, cliente).
				                groupBy(factura.cliente.id).
				                list(factura.cliente.id, factura.total.sum());
		for(Tuple t:rs7){
			System.out.println(t);
		}
		
		//Delete		
		System.out.println("==================================================");
		em.getTransaction().begin();
		new JPADeleteClause(em, factura).where(factura.cliente.id.eq(1)).execute();		
		
		new JPAUpdateClause(em, cliente).set(cliente.nombre, "Rigodofredóndio").execute();
		em.getTransaction().commit();
		
		em.close();

	}
	
}
