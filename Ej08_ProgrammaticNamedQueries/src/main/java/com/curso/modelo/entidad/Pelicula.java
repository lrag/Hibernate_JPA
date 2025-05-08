package com.curso.modelo.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@NamedQueries( {
	//Named query en una anotación
	@NamedQuery(name="pelicula.listarTodos",query="select p from Pelicula p"),
	}
)
@Table(name="peliculas")
public class Pelicula {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String director;
	private String genero;
	private Integer yearEstreno;

	public Pelicula() {
		super();
	}

	public Pelicula(Integer id, String titulo, String director, String genero, Integer yearEstreno) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.director = director;
		this.genero = genero;
		this.yearEstreno = yearEstreno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getYearEstreno() {
		return yearEstreno;
	}

	public void setYearEstreno(Integer yearEstreno) {
		this.yearEstreno = yearEstreno;
	}

}
