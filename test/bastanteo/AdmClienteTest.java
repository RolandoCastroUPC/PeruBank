package bastanteo;



import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

import BLL.AdmClientes;
import BLL.ClienteException;
import ENT.Cliente;


public class AdmClienteTest {

	@Test
	public void siIngresoDatosDeberiaRegistrarCliente() throws ClienteException{
		
		//preparamos el ejemplo
        String ruc = "12232720907";
        String codigo = "CL001";
        String razonSocial = "Extreme IT Solutions";
       
        DateFormat df = DateFormat.getDateInstance(); 
		 Date fechaInicio = null;
		try {
			fechaInicio = df.parse("30/05/2012");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String tipoEmpresa = "SAC";
        int empleados = 10;
       
		 AdmClientes adm = new AdmClientes();	
        //ejecutar
        adm.registrarCliente(codigo, ruc, razonSocial,
        		fechaInicio, tipoEmpresa, empleados);
         
        
        Cliente cliente = adm.buscarCliente(codigo);
        // Verificar
        assertNotNull(cliente);
	}
	
	
	@Test(expected=ClienteException.class)
	public void deberiaValidarDatosRequeridos() throws ClienteException  {
		
		//preparar el ejemplo
        String ruc = "";
        String codigo = "";
        String razonSocial = "";

        DateFormat df = DateFormat.getDateInstance(); 
		 Date fechaInicio = null;
		try {
			fechaInicio = df.parse("30/05/2012");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String tipoEmpresa = "SAC";
        int empleados = 10;
        AdmClientes adm = new AdmClientes();
        
        //ejecutar
        adm.registrarCliente(codigo, ruc,
        		razonSocial, fechaInicio, tipoEmpresa, 
        		empleados);
        
	}
	
	@Test(expected=ClienteException.class)
	public void  noDeberiaRegistrarClientesDuplicados() throws ClienteException{
		//preparamos el escenario
		 // Arrange
        String ruc = "12232720907";
        String codigo = "CL001";
        String razonSocial = "Extreme IT Solutions";
        
        DateFormat df = DateFormat.getDateInstance(); 
		 Date fechaInicio = null;
		try {
			fechaInicio = df.parse("30/05/2012");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String tipoEmpresa = "SAC";
        int empleados = 10;
        AdmClientes adm = new AdmClientes();
        
        //ejecutar
        //el primero se ejecuta sin problemas
        adm.registrarCliente(codigo, ruc, razonSocial,
        		fechaInicio, tipoEmpresa, empleados);
        
        //el segundo debe arrojar la exception
        adm.registrarCliente(codigo, ruc, razonSocial, 
        		fechaInicio, tipoEmpresa, empleados);	
	
	}
	
	
	
	
	
}
