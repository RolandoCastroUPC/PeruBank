package bastanteo;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import junit.extensions.RepeatedTest;
import junit.framework.Assert;

import org.junit.Test;

import BLL.AdmRepresentantes;
import BLL.GestionUsuarios;
import BLL.GestionUsuariosException;
import BLL.RepresentantesException;
import ENT.GrupoBastanteo;
import ENT.Representantes;
import ENT.TipoUsuario;

public class AdmRepresentanteTest {
	
	@Test
	public void siIngresoDatosDeberiaRegistrarRepresentante() throws RepresentantesException, GestionUsuariosException{
		
		//preparamos el ejemplo
		
		
		
		
		
		String tipodocumento = "01";
		int numerodocumento = 1010;
		String codigocliente = "2880";
		int representante = 10 ;
		String nombres = "Carlos";
		String apellidos = "Ferrer";
		String cargo = "Jefe";
		int grupobastanteo = 1 ;
		
		
		//CAPA CREADA POR: ROLANDO CASTRO
		TipoUsuario tipoUsuario ;
		tipoUsuario = TipoUsuario.ABOGADO;
		
		String cuenta ="abogado";
		String contrasena = "abogado";
		//CAPA CREADA POR: ROLANDO CASTRO
		
        AdmRepresentantes  adm = new AdmRepresentantes();	
		
        
        
        //ejecutar
        
    	//CAPA CREADA POR: ROLANDO CASTRO
		GestionUsuarios gestionUsuarios = new 	GestionUsuarios();
		//DEBERIA VALIDAR USUARIO
		gestionUsuarios.ValidaAutenticacionUsuario(cuenta, contrasena);
		
		//SIN PRIVILEGIOS
		//gestionUsuarios.ValidaAutenticacionUsuario("abogado", "abogado");
		
		assertNotNull(gestionUsuarios.getUsuario());

		assertEquals(gestionUsuarios.getUsuario().getTipodeUsuario(), tipoUsuario);
		//CAPA CREADA POR: ROLANDO CASTRO
		
        adm.registrarRepresentante(tipodocumento, numerodocumento, codigocliente,  representante, nombres, apellidos, cargo,  grupobastanteo);
 
        
        Representantes representantes = adm.buscarRepresentante(tipodocumento, numerodocumento);
        // Verificar
        assertNotNull(representantes);
	}
	
	@Test
	public void ValidarDatosIngresados() throws RepresentantesException,GestionUsuariosException{
		
		

		String tipodocumento = "01";
		int numerodocumento = 1010;
		String codigocliente = "2880";
		int representante = 10 ;
		String nombres = "Carlos";
		String apellidos = "Ferrer";
		String cargo = "Jefe";
		int grupobastanteo = 1 ;
		
		
		
		
		//CAPA CREADA POR: ROLANDO CASTRO
		TipoUsuario tipoUsuario ;
		tipoUsuario = TipoUsuario.ABOGADO;
		
		String cuenta ="abogado";
		String contrasena = "abogado";
		//CAPA CREADA POR: ROLANDO CASTRO
		
        AdmRepresentantes  adm = new AdmRepresentantes();	
		
        
        
        //ejecutar
        
    	//CAPA CREADA POR: ROLANDO CASTRO
		GestionUsuarios gestionUsuarios = new 	GestionUsuarios();
		//DEBERIA VALIDAR USUARIO
		gestionUsuarios.ValidaAutenticacionUsuario(cuenta, contrasena);
		
		//SIN PRIVILEGIOS
		//gestionUsuarios.ValidaAutenticacionUsuario("abogado", "abogado");
		
		assertNotNull(gestionUsuarios.getUsuario());

		assertEquals(gestionUsuarios.getUsuario().getTipodeUsuario(), tipoUsuario);
		//CAPA CREADA POR: ROLANDO CASTRO
		adm.registrarRepresentante(tipodocumento, numerodocumento, codigocliente,  representante, nombres, apellidos, cargo,  grupobastanteo);
		adm.registrarRepresentante(tipodocumento, numerodocumento, codigocliente,  representante, nombres, apellidos, cargo,  grupobastanteo);
        
        
        Representantes representantes = adm.buscarRepresentante(tipodocumento, numerodocumento);
        // Verificar
        assertNotNull(representantes);
	}
	
	
	@Test
	public void siIngresoDatosNulosNoDeberiaRegistrarRepresentante() throws RepresentantesException,GestionUsuariosException{
		
		//preparamos el ejemplo
		String tipodocumento = "";
		int numerodocumento = 0;
		String codigocliente = "";
		int representante = 0 ;
		String nombres = "";
		String apellidos = "";
		String cargo = "";
		int grupobastanteo = 0 ;
		
		//CAPA CREADA POR: ROLANDO CASTRO
		TipoUsuario tipoUsuario ;
		tipoUsuario = TipoUsuario.ABOGADO;
		String cuenta ="abogado";
		String contrasena = "abogado";
		//CAPA CREADA POR: ROLANDO CASTRO
		
        AdmRepresentantes  adm = new AdmRepresentantes();	
		
        
        
        //ejecutar
        
    	//CAPA CREADA POR: ROLANDO CASTRO
		GestionUsuarios gestionUsuarios = new 	GestionUsuarios();
		//DEBERIA VALIDAR USUARIO
		gestionUsuarios.ValidaAutenticacionUsuario(cuenta, contrasena);
		
		//SIN PRIVILEGIOS
		//gestionUsuarios.ValidaAutenticacionUsuario("abogado", "abogado");
		
		assertNotNull(gestionUsuarios.getUsuario());

		assertEquals(gestionUsuarios.getUsuario().getTipodeUsuario(), tipoUsuario);
		//CAPA CREADA POR: ROLANDO CASTRO
		
		
		
		
		adm.registrarRepresentante(tipodocumento, numerodocumento, codigocliente,  representante, nombres, apellidos, cargo,  grupobastanteo);
 
        
        Representantes representantes = adm.buscarRepresentante(tipodocumento, numerodocumento);
        // Verificar
        assertNotNull(representantes);
	}

@Test
	public void DeberiaIngresarConRolAbogado() throws RepresentantesException,GestionUsuariosException{
		
		
		
		//CAPA CREADA POR: ROLANDO CASTRO
		TipoUsuario tipoUsuario ;
		tipoUsuario = TipoUsuario.ABOGADO;
		String cuenta ="abogado";
		String contrasena = "abogado";
		//CAPA CREADA POR: ROLANDO CASTRO
        
        //ejecutar
        
    	//CAPA CREADA POR: ROLANDO CASTRO
		GestionUsuarios gestionUsuarios = new 	GestionUsuarios();
		//DEBERIA VALIDAR USUARIO
		gestionUsuarios.ValidaAutenticacionUsuario(cuenta, contrasena);
		
		//SIN PRIVILEGIOS
		//gestionUsuarios.ValidaAutenticacionUsuario("abogado", "abogado");
		
		assertNotNull(gestionUsuarios.getUsuario());

		assertEquals(gestionUsuarios.getUsuario().getTipodeUsuario(), tipoUsuario);
		//CAPA CREADA POR: ROLANDO CASTRO
		
      
	}

@Test
	public void noDeberiaIngresarSinRolAbogado() throws RepresentantesException,GestionUsuariosException{
		
		
		
		//CAPA CREADA POR: ROLANDO CASTRO
		TipoUsuario tipoUsuario ;
		tipoUsuario = TipoUsuario.SUPERVISOR;
		String cuenta ="abogado";
		String contrasena = "abogado";
		//CAPA CREADA POR: ROLANDO CASTRO
        
        //ejecutar
        
    	//CAPA CREADA POR: ROLANDO CASTRO
		GestionUsuarios gestionUsuarios = new 	GestionUsuarios();
		//DEBERIA VALIDAR USUARIO
		gestionUsuarios.ValidaAutenticacionUsuario(cuenta, contrasena);
		
		//SIN PRIVILEGIOS
		//gestionUsuarios.ValidaAutenticacionUsuario("abogado", "abogado");
		assertEquals(gestionUsuarios.getUsuario().getTipodeUsuario(), tipoUsuario);
		assertNotNull(gestionUsuarios.getUsuario());

		
		//CAPA CREADA POR: ROLANDO CASTRO
		
      
	}

	
	
	

}
