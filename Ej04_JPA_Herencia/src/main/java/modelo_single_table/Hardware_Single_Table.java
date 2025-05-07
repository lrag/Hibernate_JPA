package modelo_single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

@Entity
//No puede tener @Table
@DiscriminatorValue(value="HW")
public class Hardware_Single_Table extends Producto_Single_Table {
	//No tiene @Id
	
	@NotNull
	protected Double peso;

	public Hardware_Single_Table() {
		super();
	}

	public Hardware_Single_Table(int idProducto, String nombre, String descripcion,
			Double peso) {
		super(idProducto, nombre, descripcion);
		this.peso = peso;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Hardware [peso=" + peso + ", idProducto=" + idProducto
				+ ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

}




