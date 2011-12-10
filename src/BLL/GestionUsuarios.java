package BLL;

import java.util.ArrayList;
import java.util.List;

import ENT.Cliente;
import ENT.TipoUsuario;
import ENT.Usuarios;


public class GestionUsuarios {
	
	 List<Usuarios> listaUsuarios = new ArrayList<Usuarios>();
	 public GestionUsuarios()
	 {
		
		 listaUsuarios.add(new Usuarios("administrador","administrador",TipoUsuario.ADMINISTRADOR));	
		 listaUsuarios.add(new Usuarios("supervisor","supervisor",TipoUsuario.SUPERVISOR));
		 listaUsuarios.add(new Usuarios("abogado","abogado",TipoUsuario.ABOGADO));
		 listaUsuarios.add(new Usuarios("empleado","empleado",TipoUsuario.EMPLEADO));
         //comentario para todos
		 
		 //Comentarios para subir
		 
		 
		//Comentarios para 2
		
	 }
	 Usuarios Usuario = null;
	 public boolean ValidaAutenticacionUsuario(String cuenta, String contrasena) throws GestionUsuariosException  {
		 boolean existe = false;
	        for(Usuarios usuario : listaUsuarios)
	            if (usuario.getCuenta().equals(cuenta) && usuario.getContrasena().equals(contrasena) )
	            {
	                throw  new GestionUsuariosException("Usuario Existe"); 
	               
	            }
	                
	    return false;
		}
	 
	 public Usuarios BuscaUsuario(String cuenta, String contrasena)  throws GestionUsuariosException  {
		
	        for(Usuarios usuario : listaUsuarios)
	            if (usuario.getCuenta().equals(cuenta) && usuario.getContrasena().equals(contrasena) )
	            {
	            	
	            	return usuario;
	            }
	        throw  new GestionUsuariosException("No se encontro el usuario");         
	   
		}
	 public Usuarios getUsuario()
	 {
		 return Usuario;
	 }
	 
	 public void RegistraUsuario(String cuenta, String contrasena,TipoUsuario tipoUsuario)
	 throws GestionUsuariosException 
		
	 {
		
				String mensaje = "";
			    if (cuenta.equals(""))
			        mensaje += "Cuenta no puede ser vacio";
			    if (contrasena.equals(""))
			        mensaje += "\nContraseña no puede ser vacio";
			    if (tipoUsuario == null)
			        mensaje += "\nTipo de usuario no puede ser vacio";
			    if (! mensaje.equals(""))
			    	
			        throw  new GestionUsuariosException(mensaje); 
			    ValidaAutenticacionUsuario(cuenta,contrasena);
			    listaUsuarios.add(new Usuarios(cuenta,contrasena,tipoUsuario));
	 }
	 
	 

}
