package bastanteo;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

import BLL.AdmBastantearPoder;
import BLL.AdmClientes;
import BLL.AdmPoderes;
import BLL.AdmRepresentantes;
import BLL.ClienteException;
import BLL.RepresentantesException;
import ENT.Cliente;
import ENT.Representantes;

public class ConsultarPoderesTest {
	
	
	AdmClientes nuevoCliente = new AdmClientes();
	AdmRepresentantes nuevoRepresentante = new AdmRepresentantes();
	AdmPoderes nuevoPoderes = new AdmPoderes();
	AdmBastantearPoder nuevoBastanteo = new AdmBastantearPoder();
	
	
	 
	
	
 	@Test 
 	public void ConsultarPoderes() throws ClienteException, RepresentantesException{
 		
 		
 		cargadatosParaTest();
 		Cliente cliente = nuevoCliente.buscarClienteRuc("20382572425");
 	    Representantes representantes = nuevoRepresentante.buscarRepresentanteCliente(cliente.getCodigo(), 2000);
 	     
 	     
 	    System.out.println("Código Cliente..........: " + cliente.getCodigo());
 	    if (representantes == null){
 	    	System.out.println("No Existe Representantes");
 	    }
 	    else
 	    {
	     System.out.println("Representante...........: " + representantes.getRepresentante());
	     System.out.println("Nombre Representante... : " + representantes.getNombres());
	     System.out.println("Apellido Representante .: " + representantes.getApellidos());
	     System.out.println("Grupo Bastanteo .: " + representantes.getGrupobastanteo());
 	    }
 	}
	
	
	
	
	
	public void cargadatosParaTest() throws RepresentantesException, ClienteException{
		DateFormat df = DateFormat.getDateInstance(); 
		 Date fechaInicio = null;
		 try {
			fechaInicio = df.parse("30/05/2012");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 /* Clientes */ 
		 	
	     nuevoCliente.registrarCliente("50681", "20424580237",  "INV MARTINEZ",	fechaInicio, "S.A.C", 10);
	     nuevoCliente.registrarCliente("15144", "20506603626", "DISVISA SAC",	fechaInicio, "S.A.C", 20);
	     nuevoCliente.registrarCliente("40493", "20382572425",  "ALBRESA SAC",	fechaInicio, "S.A.C", 30);
	     
	     
	     /*Representantes*/
	     
	     
	     nuevoRepresentante.registrarRepresentante("01", 101010,  "50681", 1000, "JESSICA", "TRELLES", "JEFA DE AREA", 1);
	     nuevoRepresentante.registrarRepresentante("01", 101011,  "15144", 2000, "GABRIELA", "PADILLA", "JEFA DE AREA", 2);
	     nuevoRepresentante.registrarRepresentante("02", 101012,  "40493", 2000, "GABRIELA", "PADILLA", "JEFA DE AREA", 3);
	     
	     /* Poderes */
	     
	     nuevoPoderes.registrarPoder(100, 101010, "CHCO", "COBRO DE CHEQUES", "ACTIVO");
	     nuevoPoderes.registrarPoder(101, 101011, "EFRE", "RETIRO EN EFECTIVO", "PASIVO");
	     nuevoPoderes.registrarPoder(102, 101012, "CHCO", "COBRO DE CHEQUES", "ACTIVO");
	     
	     
	   
		 Date fechaVencimiento = null;
		try {
			fechaVencimiento = df.parse("31/12/2011");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		java.util.Date fecharegistro = new Date();
	     
	     
		
		
	     /*Bastantear Poder*/
	     
	     nuevoBastanteo.registrarBastantearPoder(100, "50681", "CFERRER",  1, 1, "01", 1000, fechaVencimiento, fecharegistro);
	     try {
			fechaVencimiento = df.parse("31/01/2012");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     nuevoBastanteo.registrarBastantearPoder(101, "15144", "CFERRER", 2, 2, "01", 2000, fechaVencimiento, fecharegistro);
	     try {
			fechaVencimiento = df.parse("31/02/2012");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	     nuevoBastanteo.registrarBastantearPoder(102, "40493", "CFERRER", 2, 2, "02", 2500, fechaVencimiento, fecharegistro);
		
		
	}
	
	
	

}
