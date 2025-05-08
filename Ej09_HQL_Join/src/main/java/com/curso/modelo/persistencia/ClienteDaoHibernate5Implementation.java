package com.curso.modelo.persistencia;

import org.hibernate.Session;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.utl.HibernateUtil;

import jakarta.persistence.Query;

public class ClienteDaoHibernate5Implementation implements ClienteDao {

	@Override
	public void insertar(Cliente cliente) {
		Session s = HibernateUtil.getSession();
		s.getTransaction().begin();
		s.persist(cliente);
		s.getTransaction().commit();
		s.close();
	}
	
	@Override
	public Cliente buscar(Integer id) {
		Session s = HibernateUtil.getSession();
		Cliente c = s.find(Cliente.class, id);
		s.close();
		return c;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public Cliente buscarConFacturas(Integer id) {
		Session s = HibernateUtil.getSession();
		Query q = s.createQuery("from Cliente c join fetch c.facturas where c.id=:id", Cliente.class);
		q.setParameter("id", id);
		Cliente c = (Cliente) q.getResultList().stream().findFirst().orElse(null);
		s.close();
		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Cliente buscarConFacturasYDetalles(Integer id) {
		Session s = HibernateUtil.getSession();
		Query q = s.createQuery("from Cliente c "
				+ "join fetch c.facturas as f "
				+ "join fetch f.detalles where c.id=:id", Cliente.class);
		q.setParameter("id", id);
		Cliente c = (Cliente) q.getResultList().stream().findFirst().orElse(null);
		s.close();
		return c;
	}
	
}
