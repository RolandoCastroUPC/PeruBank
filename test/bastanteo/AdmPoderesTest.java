package bastanteo;

import org.junit.Test;

import BLL.AdmPoderes;
import BLL.ClienteException;

public class AdmPoderesTest {
	
	
	@Test
	public void siIngresoDatosDeberiaRegistrarPoderes() throws ClienteException{
		
		
		int poderes = 1;
	    int numerodocumento = 1010 ;
	    String codigocorto = "CHCO";
	    String nombre = "Cobro Cheques"; ;
	    String  productoservicio = "Activo";;
		
		
		AdmPoderes adm = new AdmPoderes();
		
		adm.registrarPoder(poderes, numerodocumento, codigocorto, nombre, productoservicio);
		
	}
	
	
	
	
	@Test
	public void noDeberiaRegistrarPoderesDuplicados() throws ClienteException{
		
		
		
		
		
		
	    int poderes = 1;
	    int numerodocumento = 1010 ;
	    String codigocorto = "CHCO";
	    String nombre = "Cobro Cheques"; ;
	    String  productoservicio = "Activo";;
		
		
		AdmPoderes adm = new AdmPoderes();
		
		adm.registrarPoder(poderes, numerodocumento, codigocorto, nombre, productoservicio);
		adm.registrarPoder(poderes, numerodocumento, codigocorto, nombre, productoservicio);
		
	
	}

}
