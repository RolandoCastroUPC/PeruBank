package bastanteo;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import org.junit.Test;

import ENT.Cliente;

public class ClienteTest {

	
	
	@Test
	public void clienteDeberiaCrearseConDatosIniciales(){
		
		//Preparo el escenario	
        String ruc = "20565455656";
        String codigo = "CL001";
        String razonSocial = "ACME Solutions";
                
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
        
		//Ejecuto el escenario
        Cliente cliente = new Cliente(codigo, ruc,
        		razonSocial, fechaInicio, tipoEmpresa, empleados);
		
		//Verifico
        assertEquals(codigo, cliente.getCodigo());
        assertEquals("111", cliente.getRuc());
        assertEquals(razonSocial, cliente.getRazonsocial());
        assertEquals(fechaInicio, cliente.getFechaInicio());
        assertEquals(tipoEmpresa, cliente.getTipoEmpresa());
        assertEquals(empleados, cliente.getEmpleados());   
		
	}
}
