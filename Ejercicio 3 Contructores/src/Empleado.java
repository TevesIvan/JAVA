
public class Empleado {
	private String dni;
	private String nombre;
	private String apellido;
	private String email;
	private float sueldoBase;
	String getApellido() {
		return apellido;
	}
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getEmail() {
		return email;
	}
	public float getSueldoBase() {
		return sueldoBase;
	}
	void setApellido(String apellido) {
		this.apellido = apellido;}
	void setDni(String dni) {
		this.dni = dni;}
	void setEmail(String email) {
		this.email = email;}
	void setNombre(String nombre) {
		this.nombre = nombre;}
	void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	public Empleado(String apellido,String dni,String email,String nombre,float sueldoBase)
	{
		this.apellido = apellido;
		this.dni = dni;
		this.email = email;
		this.nombre = nombre;
		this.sueldoBase = sueldoBase;
	}

	

	float getSueldo(){
		System.out.println("el sueldo es ");
		 float sueldo=this.getSueldo();
		 return (sueldo);
		
	}
}