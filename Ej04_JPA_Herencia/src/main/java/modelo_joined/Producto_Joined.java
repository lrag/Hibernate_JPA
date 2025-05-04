package modelo_joined;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name="producto_joined") //Puede tener @Table
@Inheritance(strategy=InheritanceType.JOINED)
//Tambien puede tener discriminator column (si no se la inventa)
public class Producto_Joined { //Tambien puede ser abstracta (deber�a ser abstracta)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="productosSeq")
	//@SequenceGenerator(name="productosSeq", sequenceName="productos_seq", initialValue=0, allocationSize=1)
	@Column(name="id_producto")
	protected int idProducto;
	protected String nombre;
	protected String descripcion;

	public Producto_Joined() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto_Joined(int idProducto, String nombre, String descripcion) {
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
