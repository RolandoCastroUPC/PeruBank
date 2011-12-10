package ENT;

public class Poderes {
	
	
	private int poderes;
	private int numerodocumento ;
    private String codigocorto ;
    private String nombre;
    private String  productoservicio ;
    
    
    public Poderes(int poderes, int numerodocumento, String codigocorto, String nombre, String productoservicio) {
		super();
		this.poderes = poderes;
		this.numerodocumento = numerodocumento ;
		this.codigocorto = codigocorto;
		this.nombre = nombre;
		this.productoservicio = productoservicio;
	}


	public int getPoderes() {
		return poderes;
	}


	public int getNumerodocumento() {
		return numerodocumento;
	}


	public String getCodigocorto() {
		return codigocorto;
	}


	public String getNombre() {
		return nombre;
	}


	public String getProductoservicio() {
		return productoservicio;
	}


    


}
