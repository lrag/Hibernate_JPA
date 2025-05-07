package modelo_single_table;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity //Esto es una entidad (aunque la clase fuera abstracta)
@Table(name="producto_single_table") //Puede tener table
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) //Escogemos la estrategia single table
//Con single table hay que añadir una columna extra a la tabla
//Que será invisible para la aplicacion. 
//Lo escogemos de tipo string y logitud de dos caracteres
@DiscriminatorColumn(name="tipo", discriminatorType=DiscriminatorType.STRING, length=2)
//A los productos les corresponde 'PR' en 'tipo'
@DiscriminatorValue(value="PR")
public class Producto_Single_Table { //Tambien puede ser abstracta (debería ser abstracta)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	protected int idProducto;
	protected String nombre;
	protected String descripcion;

	public Producto_Single_Table() {
		super();
	}

	public Producto_Single_Table(int idProducto, String nombre, String descripcion) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + "]";
	}

}
