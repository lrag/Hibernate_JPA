import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.entidad.DetalleFactura;
import com.curso.modelo.entidad.Factura;
import com.curso.modelo.persistencia.ClienteDao;
import com.curso.modelo.persistencia.ClienteDaoHibernate5Implementation;
import com.curso.modelo.persistencia.utl.HibernateUtil;

public class Pruebas {

	@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
	public static void main(String[] args) {
		
		Cliente c = new Cliente(null, "Bender", "NNY", "555");
		Factura f1 = new Factura(null, "FAC-1", LocalDate.now(), c);
		Factura f2 = new Factura(null, "FAC-2", LocalDate.now(), c);
		Factura f3 = new Factura(null, "FAC-3", LocalDate.now(), c);
		Factura f4 = new Factura(null, "FAC-4", LocalDate.now(), c);
		Factura f5 = new Factura(null, "FAC-5", LocalDate.now(), c);
		
		Set<DetalleFactura> detalles = new HashSet() {{
			add(new DetalleFactura(null,1d,2d,"P1",f1));
			add(new DetalleFactura(null,1d,2d,"P2",f1));
			add(new DetalleFactura(null,1d,2d,"P3",f1));
		}};
		f1.setDetalles(detalles);
		
		Set<Factura> facturas = new HashSet<>();
		facturas.addAll(Arrays.asList(f1,f2,f3,f4,f5));
		c.setFacturas(facturas);
		
		System.out.println("===============================");
	    ClienteDao clienteDao = new ClienteDaoHibernate5Implementation();
	    clienteDao.insertar(c);
	    Integer id = c.getId();
	    System.out.println("===============================");
	    Cliente cAux1 = clienteDao.buscar(id);
	    System.out.println(cAux1);
	    System.out.println("===============================");
	    Cliente cAux2 = clienteDao.buscarConFacturas(id);
	    System.out.println(cAux2);
	    cAux2.getFacturas().forEach( f -> System.out.println(f));    

	    System.out.println("===============================");
	    Cliente cAux3 = clienteDao.buscarConFacturasYDetalles(id);
	    System.out.println(cAux3);
	    cAux3.getFacturas().forEach( f -> {
	    	System.out.println(f);
	    	if(f.getDetalles()!=null) {
	    		System.out.println(f.getDetalles());
	    	}
	    });    
		
	    HibernateUtil.closeSessionFactory();
	    
	}
	
}
