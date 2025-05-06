import java.util.List;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.ClienteResumen;
import com.curso.modelo.entidad.Pedido;
import com.curso.modelo.entidad.Producto_Joined;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class PruebasJPQL {

	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) {
		
		//El entity manager factory es threadsafe
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("H2PU");
		
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		System.out.println("============================");
		//Tienes que poner un alias (el as es opcional)
		//select * from clientes
		Query q = em.createQuery("select c from com.curso.modelo.entidad.Cliente as c");
		//Autoimport: no hace falta poner el paquete
		Query qBis = em.createQuery("select c from Cliente c");
		//Al ejecutar una consulta que devuelva objetos TODOS pasan a la cache
		List<Cliente> clientes = q.getResultList();
		for(Cliente c:clientes){
			System.out.println(c.getNombre()+","+c.getDatosBancarios());
		}

		//Cuando pedimos solo un atributo nos devuelven una lista del tipo correspondiente
		System.out.println("============================");
		List<Cliente> listaA = em.createQuery("select c from Cliente c").getResultList();
		List<String> listaB = em.createQuery("select c.nombre from Cliente c").getResultList();
		
		//Cuando pedimos m�s de un atributo nos devuelven un array de object
		Query q15 = em.createQuery("select c.id, c.nombre, c.direccion.ciudad from Cliente c");
		List<Object[]> rs = q15.getResultList();
		for(Object[] fila: rs){
			System.out.println(fila[0]+":"+fila[1]);
		}
		
		//
		//LA LISTA
		//
		
		//Podemos hacer lo mismo, pero con objetos 'resumen'
		System.out.println("============================");
		Query q16 = em.createQuery("select new com.curso.modelo.entidad.ClienteResumen(c.id, c.nombre, c.direccion.ciudad) from Cliente c");
		List<ClienteResumen> lista2 = q16.getResultList();
		for(ClienteResumen cr: lista2){
			System.out.println(cr.getNombre()+","+cr.getDireccion());
		}		
		
		//WHERE
		Query q2 = em.createQuery("select c from Cliente c where c.nombre='Ringo'");
		Query q3 = em.createQuery("select c from Cliente c where c.nombre='Ringo' or c.direccion.ciudad='X'");
		Query q4 = em.createQuery("select c from Cliente c where c.nombre='Ringo' and c.direccion.ciudad='X'");
		Query q5 = em.createQuery("select p from Producto_Joined p where p.precio>100 and p.precio<200");
		Query q6 = em.createQuery("select p from Producto_Joined p where p.precio between 100 and 200");
		//Clientes sin calle 
		Query q11 = em.createQuery("select c from Cliente c where c.direccion.calle=null");
		
		Query q7 = em.createQuery("select c from Cliente c where c.nombre like '%Bartolo%'");
		//Busca todos los clientes que tengan un nombre que empiece por B y luego tenga 3 caracteres (curiosidad)
		Query q8 = em.createQuery("select c from Cliente c where c.nombre like 'B___'");
		//In
		Query q9 = em.createQuery("select c from Cliente c where c.direccion.ciudad in ('Madrid','Salamanca','Toledo')");
			
		//Relaciones:
		//Clientes con pedidos (exige el extremo opcional)
		System.out.println("============================");
		//Dame los clientes que tienen pedidos (curiosidad)
		Query q10 = em.createQuery("select c from Cliente c where c.pedidos is not empty");
		List<Cliente> clientes2 = q10.getResultList();
		for(Cliente c:clientes2){
			System.out.println(c.getNombre()+","+c.getDatosBancarios().getNumeroTC());
		}		
				
		//Relaciones////////////////////////////////////////////////////////////////////////////////
		System.out.println("============================");
		//Pedidos de un cliente
		//Sin el extremo opcional lo hacemos as�:
		Query q12Bis = em.createQuery("select p from Pedido p where p.cliente.id = 1");
		
		//q12Bis seria equivalente a (si disponemos del extremo opcional):
		Cliente c = em.find(Cliente.class, 1);
		if(c!=null) {
			List<Pedido> pedidosBis = c.getPedidos();
		}
		
		//Podemos utilizar las relaciones directamente en la query sin necesidad de un join expl�cito
		//Aqui hay un JOIN impl�cito
		Query q12 = em.createQuery("select p from Pedido p where p.cliente.nombre like '%Ringo%'");
		List<Pedido> pedidos = q12.getResultList();
		for(Pedido p: pedidos){
			System.out.println(p.getId()+","+p.getCodigo());
		}
		
		//JOIN EXPLICITO. Se usa la colecci�n para hacer el join, no la clase
		//inner, left, right, outer
		//select c.* from clientes 
		//           left join pedidos p on p.fk_id_cliente = c.id
		//			 where p.fecha > '2022/04/01'
		//La siguiente consulta exige el extremo opcional
		
		//select c.pedidos from Cliente c
		
		Query q9a = em.createQuery("select c from Cliente c " +
								   "inner join c.pedidos p where p.fecha>'2017/09/20'");
			
		//Un equivalente sin join ser�a (pero hace un join, est� implicito):
		//Esta consulta no necesita el extremo opcional
		Query q9Bis = em.createQuery("select distinct(p.cliente) from Pedido p " +
		 							 "where p.fecha>'2017/09/20'");
		
		//JOIN IMPLICITO
		//Query q10    = s.createQuery("from Pedido p inner join Cliente c where c.direccion.ciudad = 'Barcelona'");
		//Mejor as�:
		Query q10Bis = em.createQuery("select p from Pedido p where p.cliente.direccion.ciudad='Barcelona'");
		
		//Funciones
		System.out.println("============================");
		//Query q14Bis = s.createQuery("select max(p.stock) as max from Producto p");
		//Query q14Bis2 = s.createQuery("select avg(p.p) as media from Producto p");
		Query q13 = em.createQuery("select c from Cliente c where substring(c.nombre,1,1)='A'");
		//where lower(x.nombre)='abc'
		//where length(x.nombre)=5
		Query q14 = em.createQuery("select max(p.precio) from Producto_Joined p");
		List<Integer> lista = q14.getResultList();
		System.out.println("MAX 1:"+lista.get(0));
		//Si sabemos que solo hay un resultado:
		Double max = (Double) q14.getSingleResult();
		System.out.println("MAX 2:"+max);
		
		//Expresiones
		// +, -, *, /
		// =, <=, >=, <>, !=, like
		//AND, OR, NOT, XOR
		//()
		//IN, NOT IN, BETWEEN, IS NULL, IS NOT NULL
		//IS EMPTY 'dame los clientes que no tienen pedidos, IS NOT EMPTY
		//EJBQL: substring(), trim(), lower(), upper(), length(), abs(), sqrt(), mod()
		//       current_date(), current_time(), current_timeStamp()		
		
		//Consultas polimorficas
		//Consulta por la superclase
		System.out.println("============================");
		Query q17 = em.createQuery("select p from Producto_Joined p");
		List<Producto_Joined> productos = q17.getResultList();
		for(Producto_Joined p: productos){
			System.out.println(p.getNombre()+":"+p.getClass());
		}
		//Tambien se puede consultar a una subclase
		Query q18 = em.createQuery("select hw from Hardware_Joined hw");
		
		//Quiero solo los software y los hardware 
		Query q18Bis = em.createQuery("from Producto_Joined p where p.class=Software_Joined or p.class=Hardware_Joined");
		//List<Producto_Joined> rs6 = q12.list();
				
		//Par�metros
		//JAMAS debemos hacer esto. No se debe concatenar a una query. PENA DE MUERTE:
		//JPA usa �nicamente PreparedStatements
		int precioMax = 150;
		//Adem�s si contatenamos nos exponemos a la inyecci�n de sql
		Query q19 = em.createQuery("select p from Producto_Joined p where p.precio<="+precioMax);
		//Esto es lo correcto:
		Query q20 = em.createQuery("select p from Producto_Joined p where p.precio>=?1 and p.precio<=?2");
		q20.setParameter(1, 60);
		q20.setParameter(2, 110);		
		
		//Parametros con nombre
		Query q21 = em.createQuery("select p from Producto_Joined p "
								   + "where p.precio>=:minimo and p.precio<=:maximo");
		q21.setParameter("minimo", 60);
		q21.setParameter("maximo", 110);
		
		//Los m�todos relacionados con consultas siempre devuelven la consula (curiosidad)
		Query q22 = em
			.createQuery("select p from Producto_Joined p where p.precio>=?1 and p.precio<=?2")
			.setParameter(1, 60)
			.setParameter(2, 110);
		
		//Orderby
		Query q23    = em.createQuery("select c from Cliente c order by c.nombre Desc");
		Query q23Bis = em.createQuery("select c from Cliente c order by c.nombre, c.direccion Desc");
		
		//Group by
		//select distinct
		//...
		
		//BULK UPDATE
		//Subir un 5% los precios de todos los productos
		//Todos los productos se quedar�an en la cach�
		Query q24 = em.createQuery("select p from Producto_Joined p");
		List<Producto_Joined> productos3 = q24.getResultList();
		for(Producto_Joined p: productos3){
			p.setPrecio(p.getPrecio()*1.05);
		}
		//Lo mismo pero con un update
		//Ninguna fila afectada por el update va a la cach�
		//y se ejecuta una �nica consulta
		Query q25 = em.createQuery("update Producto_Joined p set p.precio=p.precio*1.05");
		int numModificados = q25.executeUpdate();
		
		//BULK DELETE
		List<Producto_Joined> productos4 = q24.getResultList();
		for(Producto_Joined p: productos4){
			//em.remove(p);
		}
		//Lo mismo
		//Query q26 = em.createQuery("delete p from Producto_Joined p");
		
		em.getTransaction().commit();
		
		//NAMED QUERY
		Query q27 = em.createNamedQuery("cliente.listarTodos");

		em.close();
	}
	
}
