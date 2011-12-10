package bastanteo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import BLL.AdmBastantearPoder;
import BLL.ClienteException;
import ENT.BastantearPoder;


public class AdmBastantearPoderTest {
	
		
	
	
	@Test	
    public void ValidacionesCamposBastanteo()  throws ClienteException {
		 
		
		
		 int poderes = 1;
		 String codigocliente = "C0001";
		 String usuario = "CFERRER";
		 int grupobastanteo = 1;
		 int combinacionbastanteo = 20;
		 String intervencion = "01";
		 double importe = 120.00;
		 
		 DateFormat df = DateFormat.getDateInstance(); 
		 Date fechavencimiento = null;
		try {
			fechavencimiento = df.parse("30/06/2012");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.util.Date fecharegistro = new Date();
		
		
		 	
	
		AdmBastantearPoder adm = new AdmBastantearPoder();
		adm.registrarBastantearPoder(poderes, codigocliente, usuario, grupobastanteo, combinacionbastanteo, intervencion, importe, fechavencimiento, fecharegistro);
		
		BastantearPoder oBastantearPoder = adm.BuscaBastanteo(poderes, codigocliente, grupobastanteo, combinacionbastanteo, intervencion);
		
		
		assertEquals(poderes, oBastantearPoder.getPoderes());
		assertEquals(codigocliente, oBastantearPoder.getCodigocliente());
		assertEquals(usuario, oBastantearPoder.getUsuario());
		assertEquals(grupobastanteo, oBastantearPoder.getGrupobastanteo());
		assertEquals(combinacionbastanteo, oBastantearPoder.getCombinacionbastanteo());
		assertEquals(intervencion, oBastantearPoder.getIntervencion());
		assertNotNull(oBastantearPoder.getCodigocliente());
		

	    /* assertNulls(poder, oBastantearPoder.getPoderes() ); */
	    
	        
    }
	
	
	
	

	 
	 @Test
	 public void  noDeberiaRegistrarBastanteosDuplicados() throws ClienteException{
		
		
		 int poderes = 1;
		 String codigocliente = "C000001";
		 String usuario = "CFERRER";
		 int grupobastanteo = 2;
		 int combinacionbastanteo = 20;
		 String intervencion = "02";
		 double importe = 120.00;
		 
		 DateFormat df = DateFormat.getDateInstance(); 
		 Date fechaVencimiento = null;
		try {
			fechaVencimiento = df.parse("12/12/2011");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		java.util.Date fecharegistro = new Date();
		
		AdmBastantearPoder adm = new AdmBastantearPoder();
		adm.registrarBastantearPoder(poderes, codigocliente, usuario, grupobastanteo, combinacionbastanteo, intervencion, importe, fechaVencimiento, fecharegistro);
		
		
		
		 poderes = 1;
		 codigocliente = "C000002";
		 usuario = "CFERRER";
		 grupobastanteo = 2;
		 combinacionbastanteo = 20;
		 intervencion = "02";
		 importe = 120.00;
		
		adm.registrarBastantearPoder(poderes, codigocliente, usuario, grupobastanteo, combinacionbastanteo, intervencion, importe, fechaVencimiento, fecharegistro); 

	
	} 
	
	
    
	 @Test
	 public void  ValidaUsuario() throws ClienteException{
		
		
		 int poderes = 1;
		 String codigocliente = "C000001";
		 String usuario = "CFERRER";
		 int grupobastanteo = 2;
		 int combinacionbastanteo = 20;
		 String intervencion = "02";
		 double importe = 120.00;
		 
		 DateFormat df = DateFormat.getDateInstance(); 
		 Date fechaVencimiento = null;
		try {
			fechaVencimiento = df.parse("12/12/2011");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		java.util.Date fecharegistro = new Date();
		
		AdmBastantearPoder adm = new AdmBastantearPoder();
		adm.registrarBastantearPoder(poderes, codigocliente, usuario, grupobastanteo, combinacionbastanteo, intervencion, importe, fechaVencimiento, fecharegistro);
		
		
		
		
	
	} 
          
	
      
	

	
	
	
	
	

}
