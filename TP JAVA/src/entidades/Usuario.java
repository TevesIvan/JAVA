package entidades; 
 
public class Usuario extends Persona {
	public String usuario,contrase�a;
	public boolean habilitado;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
    public Usuario(String usuario,String contrase�a,boolean habilitado,String dni,String nombre,String apellido,int id)
	{	//super(dni,nombre,apellido,id); 
		this.habilitado=habilitado;
		this.usuario=usuario;
		this.contrase�a=contrase�a;
	}
}
