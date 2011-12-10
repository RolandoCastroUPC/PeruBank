package ENT;

public class GrupoBastanteo {

	
	int grupobastanteo ;
	String Nombre ;
	
	public GrupoBastanteo(int grupobastanteo, String Nombre)
	{
		super();
		this.grupobastanteo = grupobastanteo;
		this.Nombre = Nombre;
		
	}

	public int getGrupobastanteo() {
		return grupobastanteo;
	}

	public void setGrupobastanteo(int grupobastanteo) {
		this.grupobastanteo = grupobastanteo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	
	}
