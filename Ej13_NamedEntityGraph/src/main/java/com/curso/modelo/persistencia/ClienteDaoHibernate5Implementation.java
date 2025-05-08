package com.curso.modelo.persistencia;

import javax.persistence.Query;

import org.hibernate.Session;

import com.curso.modelo.entidad.Cliente;
import com.curso.modelo.persistencia.utl.HibernateUtil;

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
		Query q = s.createQuery("from Cliente c where c.id=:id");
		q.setParameter("id", id);
		q.setHint("javax.persistence.loadgraph", s.getEntityGraph("ClienteConFacturas"));

		Cliente c = (Cliente) q.getResultList()
			.stream()
				.findFirst()
					.orElse(null);
		s.close();
		return c;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Cliente buscarConFacturasYDetalles(Integer id) {
		Session s = HibernateUtil.getSession();
		Query q = s.createQuery("from Cliente where id=:id");
		q.setParameter("id", id);
		q.setHint("javax.persistence.loadgraph", s.getEntityGraph("ClienteConFacturasYDetalles"));
		Cliente c = (Cliente) q.getResultList().stream().findFirst().orElse(null);
		s.close();
		return c;
	}

}
