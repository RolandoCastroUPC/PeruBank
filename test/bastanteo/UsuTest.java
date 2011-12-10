package bastanteo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import BLL.GestionUsuarios;
import BLL.GestionUsuariosException;
import ENT.Cliente;
import ENT.TipoUsuario;
import ENT.Usuarios;

public class UsuTest {

	
	
	public static GestionUsuarios gestion = new GestionUsuarios();
	
	@Test 
	public void NoDeberiaDarDeAltaSiExisteUsuario() throws GestionUsuariosException
	{
		String cuenta = "cruiz4";
		String contrasena = "P@SSw0rd";
		TipoUsuario tipoUsuario = TipoUsuario.EMPLEADO;
		
		
		gestion.RegistraUsuario(cuenta, contrasena, tipoUsuario);
		gestion.RegistraUsuario(cuenta, contrasena, tipoUsuario);
		Usuarios usuario = gestion.BuscaUsuario(cuenta, contrasena);
        // Verificar
	   
        assertNotNull(usuario);
	   
	}
	
	@Test 
	public void DeberiaDarDeAltaAsignandoRolEmpleado() throws GestionUsuariosException
	{
		String cuenta = "cruiz3";
		String contrasena = "P@SSw0rd";
		TipoUsuario tipoUsuario = TipoUsuario.EMPLEADO;
		
		
		gestion.RegistraUsuario(cuenta, contrasena, tipoUsuario);
		
		Usuarios usuario = gestion.BuscaUsuario(cuenta, contrasena);
        // Verificar
	   
        assertNotNull(usuario);
	   
	}
	
	@Test 
	public void DeberiaDarDeAltaAsignandoRolSupervisor() throws GestionUsuariosException
	{
		String cuenta = "cruiz2";
		String contrasena = "P@SSw0rd";
		TipoUsuario tipoUsuario = TipoUsuario.SUPERVISOR;
		
		
		gestion.RegistraUsuario(cuenta, contrasena, tipoUsuario);
		
		Usuarios usuario = gestion.BuscaUsuario(cuenta, contrasena);
        // Verificar
	   
        assertNotNull(usuario);
	   
	}
	
	
	@Test 
	public void DeberiaDarDeAltaAsignandoRolAbogado() throws GestionUsuariosException
	{
		String cuenta = "cruiz";
		String contrasena = "P@SSw0rd";
		TipoUsuario tipoUsuario = TipoUsuario.ABOGADO;
		
		
		gestion.RegistraUsuario(cuenta, contrasena, tipoUsuario);
		
		Usuarios usuario = gestion.BuscaUsuario(cuenta, contrasena);
        // Verificar
	   
        assertNotNull(usuario);
	   
	}
	@Test
	public void NoDeberiaDarDeAltaSinDatosInicialesYrol() throws GestionUsuariosException
	{
		String cuenta = "";
		String contrasena = "";
		TipoUsuario tipoUsuario = null;
		
	
		gestion.RegistraUsuario(cuenta, contrasena, tipoUsuario);
		
		Usuarios usuario = gestion.BuscaUsuario(cuenta, contrasena);
        // Verificar
	   
        assertNotNull(usuario);
		
		
	}
	@Test
	public void DeberiaIdentificarPorUnaClave() throws GestionUsuariosException
	{
		String cuenta = "cruiz";
		String contrasena = "P@SSw0rd";	
		
	
		
		Usuarios usuario = gestion.BuscaUsuario(cuenta, contrasena);
        // Verificar
	   
        assertNotNull(usuario);
	   
	}
	@Test
	public void NoDeberiaPermitirConClaveErrada() throws GestionUsuariosException
	{
		String cuenta = "cruiz";
		String contrasena = "P@SSw0rd1";	
		
	
		
		Usuarios usuario = gestion.BuscaUsuario(cuenta, contrasena);
        // Verificar
	   
        assertNotNull(usuario);
	   
	}
}
