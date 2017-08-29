package entidades; 
 
public class Usuario extends Persona {
	public String usuario,contraseña;
	public boolean habilitado;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
    public Usuario(String usuario,String contraseña,boolean habilitado,String dni,String nombre,String apellido,int id)
	{	//super(dni,nombre,apellido,id); 
		this.habilitado=habilitado;
		this.usuario=usuario;
		this.contraseña=contraseña;
	}
}
