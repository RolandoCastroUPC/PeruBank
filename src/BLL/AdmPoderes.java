package BLL;
import ENT.Poderes;

import java.util.ArrayList;
import java.util.List;

public class AdmPoderes {
	
	
	public List<Poderes> poderes1;

	public AdmPoderes(){
	
		poderes1 = new ArrayList<Poderes>();
	}	
	
	public void registrarPoder(int poderes, int numerodocumento, String codigoCorto, String nombre,
			String productoServicio) throws ClienteException{

		validarDatos(poderes, numerodocumento, codigoCorto, nombre, productoServicio);
		
	    validarDuplicados(poderes, numerodocumento); 
		
		Poderes nuevoPoderes = new Poderes (poderes, numerodocumento, codigoCorto, nombre, productoServicio);
		
		
		
		poderes1.add(nuevoPoderes);
		
		
		
		

	}

      private void validarDuplicados(int poderes, int numerodocumento) 
			throws ClienteException{

		if (poderExiste(poderes, numerodocumento))
			throw new ClienteException("Poder duplicado");		
	} 

	private void validarDatos(int poderes, int numerodocumento, String codigoCorto, String nombre,
			String productoServicio) throws ClienteException{
		// TODO Auto-generated method stub
		String mensaje = "";
		if (poderes == 0)
			mensaje += "Poderes no puede ser 0"; 	
		if (numerodocumento == 0)
			mensaje += "Numero Documento no puede ser 0";
			
	    if (codigoCorto.equals(""))
	        mensaje += "Codigo no puede ser vacio";
	    if (nombre.equals(""))
	        mensaje += "\nNombre no puede ser vacio";
	    if (productoServicio.equals(""))
	        mensaje += "\nProducto/Servicio no puede ser vacio";
	    if (!mensaje.equals(""))
	        throw  new ClienteException(mensaje);
	}

	 private boolean poderExiste(int poderes, int numerodocumento) {
		boolean existe = false;

        for(Poderes poderes2 : poderes1){
        	  if (poderes2.getPoderes() == poderes &&
                poderes2.getNumerodocumento() == numerodocumento)
                existe = true;
        }
		return existe;
	}

public Poderes buscarPoderPorNumeroDocumento(int numerodocumento) {
		// TODO Auto-generated method stub
        for(Poderes poderes : poderes1)
            if (poderes.getNumerodocumento() == numerodocumento)
                return poderes;
        return null;
	} 

}
