package modelo_single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value="CO")
public class Consultoria_Single_Table extends Producto_Single_Table {

	protected int precioPorCabeza;

	public Consultoria_Single_Table() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consultoria_Single_Table(int idProducto, String nombre, String descripcion,
			int precioPorCabeza) {
		super(idProducto, nombre, descripcion);
		this.precioPorCabeza = precioPorCabeza;
	}

	public int getPrecioPorCabeza() {
		return precioPorCabeza;
	}

	public void setPrecioPorCabeza(int precioPorCabeza) {
		this.precioPorCabeza = precioPorCabeza;
	}

	@Override
	public String toString() {
		return "Consultoria [precioPorCabeza=" + precioPorCabeza
				+ ", idProducto=" + idProducto + ", nombre=" + nombre
				+ ", descripcion=" + descripcion + "]";
	}

}
