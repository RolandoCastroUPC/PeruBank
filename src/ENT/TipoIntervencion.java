package ENT;

public class TipoIntervencion {
	
	
	
	private String intervencion;
	private String descripcion;
	
	
	
	
	
	public TipoIntervencion(String intervencion, String descripcion) {
		super();
		this.intervencion = intervencion;
		this.descripcion = descripcion;
	} 
	
	
	
	
	
	

	public String getIntervencion() {
		return intervencion;
	}







	public void setIntervencion(String intervencion) {
		this.intervencion = intervencion;
	}







	public String getDescripcion() {
		return descripcion;
	}







	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}







	@Override
	public String toString() {
		
		return intervencion + "," + descripcion ;
	}
	
	
           


}
