package ENT;

public class TipoProducto {
    int ID = -1;
    String Nombre = "";
    
    
    public int getID()
    {
      return ID;
    }
    public String getNombre()
    {
      return Nombre;
    }
    public TipoProducto(int id, String nombre)
    {
	    this.ID = id;	
	    this.Nombre = nombre;
    }
    
}
