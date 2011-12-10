package ENT;

public class Poder {

	private String Poderes;
	private String Nombre;
	private String ProductoServicio;
	
	public Poder(String poderes, String nombre, String productoServicio) {
		super();
		this.Poderes = poderes;
		this.Nombre = nombre;
		this.ProductoServicio = productoServicio;
	}

	public String getCodigoCorto() {
		// TODO Auto-generated method stub
		return Poderes;
	}

	public String getNombre() {
		// TODO Auto-generated method stub
		return Nombre;
	}
	
	public String getProductoServicio() {
		// TODO Auto-generated method stub
		return ProductoServicio;
	}

}
