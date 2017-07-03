package entidades;

public class Persona {
	public String dni,nombre,apellido;
	public int id;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Persona(String dni,String nombre,String apellido,int id)
	{
		this.dni=dni;
		this.nombre=nombre;
		this.apellido=apellido;
		this.id=id;
	}
}
