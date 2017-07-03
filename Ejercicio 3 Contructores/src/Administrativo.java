
public class Administrativo extends Empleado {
	private int hsExtra;
	private int hsMes;

	int getHsExtra() {
		return hsExtra;
	}

	void setHsExtra(int hsExtra) {
		this.hsExtra = hsExtra;
	}

	int getHsMes() {
		return hsMes;
	}

	void setHsMes(int hsMes) {
		this.hsMes = hsMes;
	}
	public Administrativo(int hsExtra,int hsMes,String apellido,String dni,String email,String nombre,float sueldoBase)
	{
		super(apellido,dni,email,nombre,sueldoBase);
		this.hsExtra = hsExtra;
		this.hsMes = hsMes;
	}
	float getSueldo()
	{
		float sueldo;
		sueldo=this.getSueldoBase()*((this.getHsExtra()*1.5f+this.getHsMes())/this.getHsMes());
		return(sueldo);
	}
}
