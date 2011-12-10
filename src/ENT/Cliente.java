package ENT;

import java.util.Date;

public class Cliente {

	private String codigo;
	private String ruc;
	private String razonsocial;
	private Date fechaInicio;
	private String tipoEmpresa;
	private int empleados;

	public Cliente(String codigo, String ruc, String razonsocial,
			Date fechaInicio, String tipoEmpresa, int empleados) {
		super();  //el super siempre va en primer lugar
		this.codigo = codigo;
		this.ruc = ruc;
		this.razonsocial = razonsocial;
		this.fechaInicio = fechaInicio;
		this.tipoEmpresa = tipoEmpresa;
		this.empleados = empleados;		
	}

	public String getCodigo() {
		
		return codigo;
	}

	public String getRuc() {
		
		return ruc;
	}

	

	

	public String getRazonsocial() {
		return razonsocial;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public String getTipoEmpresa() {
		
		return tipoEmpresa;
	}

	public int getEmpleados() {

		return empleados;
	}



}
