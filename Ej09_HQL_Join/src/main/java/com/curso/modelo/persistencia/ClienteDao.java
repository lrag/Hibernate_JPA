package com.curso.modelo.persistencia;

import com.curso.modelo.entidad.Cliente;

public interface ClienteDao {

	void insertar(Cliente cliente);

	Cliente buscar(Integer id);

	Cliente buscarConFacturas(Integer id);

	Cliente buscarConFacturasYDetalles(Integer id);

}