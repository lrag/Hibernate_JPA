package modelo_single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value="SW")
public class Software_Single_Table extends Producto_Single_Table {

	protected String tecnologia;
	
	public Software_Single_Table() {
		super();
	}

	public Software_Single_Table(int idProducto, String nombre, String descripcion,
			String tecnologia) {
		super(idProducto, nombre, descripcion);
		this.tecnologia = tecnologia;
	}

	public String getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}

	@Override
	public String toString() {
		return "Software [tecnologia=" + tecnologia + ", idProducto="
				+ idProducto + ", nombre=" + nombre + ", descripcion="
				+ descripcion + "]";
	}

}
