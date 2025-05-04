package modelo_single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//No puede tener @Table
@DiscriminatorValue(value="HW")
public class Hardware_Single_Table extends Producto_Single_Table {
	//No tiene @Id
	
	protected double peso;

	public Hardware_Single_Table() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hardware_Single_Table(int idProducto, String nombre, String descripcion,
			double peso) {
		super(idProducto, nombre, descripcion);
		this.peso = peso;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Hardware [peso=" + peso + ", idProducto=" + idProducto
				+ ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

}




