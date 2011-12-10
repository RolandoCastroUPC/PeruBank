package ENT;




public class Representantes {
	
	String tipodocumento = "";
	int numerodocumento = 0;
	String codigocliente ;
	int representante ;
	String nombres = "";
	String apellidos = "";
	String cargo = "";
	int grupobastanteo ;
	
	
	
	public Representantes(	String tipodocumento,
			int numerodocumento,
			String codigocliente,
			int representante ,
			String nombres,
			String apellidos,
			String cargo,
			int grupobastanteo )
	{
		this.tipodocumento = tipodocumento;
		this.numerodocumento = numerodocumento;
		this.codigocliente = codigocliente ;
		this.representante = representante;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.cargo = cargo;
		this.grupobastanteo = grupobastanteo;
	}



	public String getTipodocumento() {
		return tipodocumento;
	}



	public int getNumerodocumento() {
		return numerodocumento;
	}



	public String getCodigocliente() {
		return codigocliente;
	}



	public int getRepresentante() {
		return representante;
	}



	public String getNombres() {
		return nombres;
	}



	public String getApellidos() {
		return apellidos;
	}



	public String getCargo() {
		return cargo;
	}



	public int getGrupobastanteo() {
		return grupobastanteo;
	}
	

}
