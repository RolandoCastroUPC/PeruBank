package ENT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class BastantearPoder {
	
	
	private int poderes;
	private String codigocliente;
	private String usuario;
	private int grupobastanteo;
	private int combinacionbastanteo;
	private String intervencion;
	private double importe ;
	private Date fechavencimiento;
	private Date fecharegistro;
	
	
	public BastantearPoder(int poderes, String codigocliente, String usuario, int grupobastanteo, int combinacionbastanteo,
			String intervencion,  double importe, Date fechavencimiento, Date fecharegistro) {
		
		
		super(); 
		this.poderes  = poderes ;
		this.codigocliente = codigocliente ;
		this.usuario = usuario ;
		this.grupobastanteo = grupobastanteo;
		this.combinacionbastanteo = combinacionbastanteo;
		this.intervencion = intervencion;
		this.importe = importe;
		this.fechavencimiento = fechavencimiento;
		this.fecharegistro = fecharegistro;
	}


	public int getPoderes() {
		return poderes;
	}
	
	
	public String getCodigocliente() {
		return codigocliente;
	}


	public String getUsuario() {
		return usuario;
	}


	
	
	


	
   public int getGrupobastanteo() {
		return grupobastanteo;
	}


public int getCombinacionbastanteo() {
		return combinacionbastanteo;
	}


public double getImporte() {
		return importe;
	}


	
	public Date getFechavencimiento() {
		return fechavencimiento;
	}


	public String getIntervencion() {
		return intervencion;
	}


	public Date getFecharegistro() {
		return fecharegistro;
	}


	
	
	
	
		

}
