package BLL;
import java.util.ArrayList;
import java.util.List;

import ENT.GrupoBastanteo;
import ENT.Representantes;
import BLL.GestionUsuarios;

public class AdmRepresentantes {
	
	//1ero. defino mi lista de un tipo dado
	List<Representantes> representantes;
	
	//2do. En el constructor inicializo
	public AdmRepresentantes(){
		representantes = new ArrayList<Representantes>();
	}
	
	public void registrarRepresentante(String tipodocumento,
			int numerodocumento,
			String codigocliente,
			int representante,
			String nombres,
			String apellidos,
			String cargo,
			int grupobastanteo )	
						 
			throws RepresentantesException 
			{
		
		
		

		
		//validar datos	
	    validarDatos(tipodocumento, numerodocumento, codigocliente, representante, nombres, apellidos, cargo,  grupobastanteo);	
	    
	    
	    //validar que no haya duplicados
	    validarDuplicado(tipodocumento, numerodocumento);
	    
		
		//Creamos un representante
	    Representantes nuevoRepresentante = new Representantes (tipodocumento, numerodocumento,  codigocliente, representante,  nombres, apellidos, cargo,	 grupobastanteo);
	    
		//añaden a la lista
		representantes.add(nuevoRepresentante);
		
	}

	
	public void validarDuplicado(String tipo,
			int numdoc) throws RepresentantesException
			 {		
	    
        if(RepresentanteExiste(tipo,numdoc)) 
        	throw new RepresentantesException("Representante Duplicado");
	}
	
	private boolean RepresentanteExiste(String tipo,
			int numdoc
			) {
		boolean existe = false;
	    
	    //   and &&   , || or
        for(Representantes representante : representantes)
            if (representante.getTipodocumento().equals(tipo) &&
            		representante.getNumerodocumento() == numdoc)
                existe = true;
		return existe;
	}
		
	
	public void validarDatos(String tipodocumento,
			int numerodocumento,
			String codigocliente,
			int representante,
			String nombres,
			String apellidos,
			String cargo,
			int grupobastanteo )	
				
		throws RepresentantesException {
		
		String mensaje = "";
	    if (tipodocumento.equals(""))
	        mensaje += "Tipo de documento no puede ser vacio";
	    if (numerodocumento == 0 )
	        mensaje += "\nNúmero De Documento no puede ser vacio";
	    if (nombres.equals(""))
	        mensaje += "\nNombre   no puede ser vacio";
	    if (apellidos.equals(""))
	        mensaje += "\nApellidos no puede ser vacio";
	    if (cargo.equals(""))
	        mensaje += "\nCargo no puede ser vacio";
	    if (grupobastanteo == 0)
	        mensaje += "\nEl grupo de bastanteo no puede ser posible";
	    
	    if (! mensaje.equals(""))
	        throw  new RepresentantesException(mensaje);
	}
	
	public Representantes buscarRepresentante(String tipodocumento, int numerodocumento) {
        for(Representantes representante : representantes)
            if (representante.getTipodocumento().equals(tipodocumento) &&  representante.getNumerodocumento() ==  numerodocumento)
                return representante;
        return null;
	}
	
	
	public Representantes buscarRepresentanteCliente(String codigocliente, int representantep) {
        for(Representantes representante : representantes)
            if (representante.getCodigocliente().equals(codigocliente) &&  representante.getRepresentante() ==  representantep)
                return representante;
        return null;
	}


}
