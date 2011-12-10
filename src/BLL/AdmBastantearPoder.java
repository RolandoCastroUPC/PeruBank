package BLL;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;


import ENT.BastantearPoder;
import ENT.GrupoBastanteo;
import ENT.TipoIntervencion;
import ENT.TipoUsuario;
import ENT.Usuarios;


public class AdmBastantearPoder {
	
	public List<BastantearPoder> bastantearpoder;
	Map m3 = new HashMap();

	public AdmBastantearPoder(){
		bastantearpoder = new ArrayList<BastantearPoder>();
	}	
	
	TipoUsuario tipusr;
	
	
	
	
	
	public void registrarBastantearPoder(int poderes, String codigocliente, String usuario, 
                int grupobastanteo, int combinacionbastanteo, String intervencion,  double importe, Date fechaencimiento, Date fecharegistro ) 
			throws ClienteException 
			{
		
		validarDatos(poderes, codigocliente, usuario, grupobastanteo, combinacionbastanteo,	intervencion,  importe, fechaencimiento);
		validarDuplicados(poderes, codigocliente, grupobastanteo, combinacionbastanteo, intervencion );
		validaTipoUsuario(usuario);
	     BastantearPoder nuevoBastanteoPoder = new BastantearPoder(poderes, codigocliente, usuario, grupobastanteo, combinacionbastanteo, intervencion,  importe, fechaencimiento, fecharegistro);
		
		
		 
		 bastantearpoder.add(nuevoBastanteoPoder);
		 
		 /* System.out.println("OK, Grabo Bastanteo"); */
		 
		
	}
	
	
	
	public BastantearPoder BuscaBastanteo(int poderes, String codigocliente, int grupobastanteo, int combinacionbastanteo,
			String intervencion  ) throws ClienteException {
        for(BastantearPoder bastanteo : bastantearpoder)
        	
        	if (bastanteo.getPoderes() == poderes && bastanteo.getCodigocliente().equals(codigocliente) && bastanteo.getGrupobastanteo() == grupobastanteo
			&& bastanteo.getCombinacionbastanteo() == combinacionbastanteo && bastanteo.getIntervencion().equals(intervencion) 	)
                    return bastanteo;
        return null;
	}
	
	
	public BastantearPoder BuscaBastanteoPoder(int poderes) throws ClienteException {
        for(BastantearPoder bastanteo : bastantearpoder)
        	
        	if (bastanteo.getPoderes() == poderes 	)
                    return bastanteo;
        return null;
	}
	
	
	
	private boolean bastanteoExiste(int poderes, String codigocliente, int grupobastanteo, int combinacionbastanteo,
			String intervencion  ) throws ClienteException {
		boolean existe = false;
		
		for (BastantearPoder bastanteo : bastantearpoder )
		{
			if (bastanteo.getPoderes() == poderes && bastanteo.getCodigocliente().equals(codigocliente) && bastanteo.getGrupobastanteo() == grupobastanteo
				&& bastanteo.getCombinacionbastanteo() == combinacionbastanteo && bastanteo.getIntervencion().equals(intervencion) 	) 
			    existe = true;
		}
		return existe ;
		
		
	}
		
	 
	    
	    //   and &&   , || or
		
        


	private void validarDatos(int poderes, String codigocliente, String usuario, int grupobastanteo, int combinacionbastanteo,
			String intervencion,  double importe, Date fechaencimiento) throws ClienteException{
		// TODO Auto-generated method stub
		// cargaTipoIntervencion();
		String mensaje = "";
		java.util.Date fecha1 = new Date();
	    if (poderes == 0)
	        mensaje += "Poderes no puede ser 0";
	    
	    
	    if(codigocliente.equals(""))
	    	mensaje +="\nCodigo cliente no puede ser blancos" ;
	    
	    
	    if (usuario.equals(""))
	        mensaje += "\nusuario no puede ser blancos";
	    
	    
	    	    
	    if (grupobastanteo == 0)
	        mensaje += "\nBastanteo no pude ser 0";
	    
	       
	    if (intervencion.equals(""))
	        mensaje += "\nTipo de Intervencion no puede ser vacio";
	    
	    
	    if   (! cargaGrupoBastanteo(grupobastanteo))
	        mensaje += "\n Grupo Bastanteo  no Existe";
	    
	    
	    if   (! cargaTipoIntervencion(intervencion))
	        mensaje += "\n Codigo de Intervencion no Existe";
	    
	    
	    if (importe == 0)
	    	mensaje += "\n Importe no puede ser 0";
	    
	    
	    if (getDateDiffInMonths(fecha1, fechaencimiento) > 6)
	    	mensaje += "\n La fecha de vencimiento no puede ser mayor a 6 meses";
	    
	    
	    if (! cargaUsuario(usuario))
	    	mensaje += "\n Usuario no Existe";
	    
	    if (! validaTipoUsuario(usuario))
	    	mensaje += "\n Usuario Autorizado Abogado";
	    
	    
	    if (!mensaje.equals(""))
	        throw  new ClienteException(mensaje);
	}
	
	
        private void validarDuplicados(int poderes, String codigocliente, int grupobastanteo, int combinacionbastanteo, String intervencion) 
        		throws ClienteException {
		
	
		
			if(bastanteoExiste(poderes, codigocliente, grupobastanteo, combinacionbastanteo, intervencion )) 
				  throw  new ClienteException("Bastanteo ya Existe");
			
		
		
		
		
		
	}
        
        
        
        private static int getDateDiffInMonths(Date startDate, Date endDate) {
            Calendar startCal = Calendar.getInstance();
            Calendar endCal = Calendar.getInstance();
            int startYear = -1, startMonth = -1;
            int endYear = -1, endMonth = -1;
            int months = 0;
            int factor = 1;
            
            if (startDate.after(endDate)) {
                factor = -1;
                startCal.setTime(endDate);
                endCal.setTime(startDate);
            } else {
                startCal.setTime(startDate);
                endCal.setTime(endDate);
            }
            startYear = startCal.get(Calendar.YEAR);
            startMonth = startCal.get(Calendar.MONTH) + 1;
            endYear = endCal.get(Calendar.YEAR);
            endMonth = endCal.get(Calendar.MONTH) + 1;
            
            if (startYear == endYear) {
                months = endMonth - startMonth;
            } else {
                months = 12 - startMonth;
                months += endMonth;
                --endYear;
                if (endYear - startYear > 0) {
                    months += (endYear - startYear)*12;
                }
            }
            months *= factor;
            return months;
        }
     
        
        
        private boolean cargaTipoIntervencion(String codIntervencion) {
        	boolean existe = false;
    		Map m1 = new HashMap();
    		m1.put("02", new TipoIntervencion("02","En Conjunto Con"));
    		m1.put("01", new TipoIntervencion("01","A Sola Firma"));
    		
    		        if (m1.containsKey(codIntervencion)) existe = true  ; 
    		
    		
    		/*TipoIntervencion e = (TipoIntervencion)m1.get("02");
    		System.out.println(e); */
			return existe;
    		
    		
    		
    	}
        
        private boolean cargaGrupoBastanteo(int idGrupoBastanteo) {
        	boolean existe = false;
    		Map m2 = new HashMap();
    		m2.put(1, new GrupoBastanteo(1,"Grupo Bastanteo 1"));
    		m2.put(2, new GrupoBastanteo(2,"Grupo Bastanteo 2"));
    		m2.put(3, new GrupoBastanteo(3,"Grupo Bastanteo 2"));
    		
    		        if (m2.containsKey(idGrupoBastanteo)) existe = true  ; 
    		
    		
    		/*TipoIntervencion e = (TipoIntervencion)m1.get("02");
    		System.out.println(e); */
			return existe;
    		
    		
    		
    	}
        
        
        private boolean cargaUsuario(String usuario) {
        	boolean existe = false;
    		
    		m3.put("CFERRER", new Usuarios("CFERRER","CFERRER", TipoUsuario.ABOGADO));
    		m3.put("CNORIEGA", new Usuarios("CNORIEGA","CNORIEGA", TipoUsuario.ADMINISTRADOR));
    		
    		
    		        if (m3.containsKey(usuario)) existe = true  ; 
    		
    		
    		/*TipoIntervencion e = (TipoIntervencion)m1.get("02");
    		System.out.println(e); */
			return existe;
    		
    		
    		
    	}

        
        private boolean validaTipoUsuario(String usuario){
        	boolean existe = false;
        	String tpUsuario ;
        	
        	if (m3.containsKey(usuario))  {
        		Usuarios e = (Usuarios)m3.get(usuario);
        		tpUsuario = e.getTipodeUsuario().toString();
        		if ( tpUsuario == "ABOGADO" ) existe = true  ;
        		
        	}
        	
        	
        	
        	
			return existe;
        	
        	
        	
        }
        
        private boolean salida01()
        {
        	return true ;
        }
        }
    	
        
	/* comentario */ 
	

