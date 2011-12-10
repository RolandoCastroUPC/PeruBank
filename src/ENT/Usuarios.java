package ENT;

public class Usuarios {

	String usuario = "";
	String Contrasena = "";
	TipoUsuario TipodeUsuario;
	public Usuarios()
	{
	
	}
	public Usuarios(	String cuenta,
			String contrasena,
			TipoUsuario tipodeUsuario)
	{
		this.usuario = cuenta;
		this.Contrasena = contrasena;
		this.TipodeUsuario = tipodeUsuario;
	}
	
	public String getCuenta() {return usuario;}
	public String getContrasena() {return Contrasena;}
	public TipoUsuario getTipodeUsuario() {return TipodeUsuario;}
}
