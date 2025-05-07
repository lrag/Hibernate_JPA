package modelo_joined;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="Hardware_joined") //Puede tener table
//Puede tener un valor para la discriminator column
public class Hardware_Joined extends Producto_Joined {
	
	//No tiene @Id
	
	@NotNull
	protected Double peso;

	public Hardware_Joined() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hardware_Joined(int idProducto, String nombre, String descripcion,
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
