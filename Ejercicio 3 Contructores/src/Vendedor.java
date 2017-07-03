
public class Vendedor extends Empleado {
	private float porcenComision;
	private float totalVentas;

	float getPorcenComision() {
		return porcenComision;
	}

	void setPorcenComision(float porcenComision) {
		this.porcenComision = porcenComision;
	}

	float getTotalVentas() {
		return totalVentas;
	}

	void setTotalVentas(float totalVentas) {
		this.totalVentas = totalVentas;
	}
	public Vendedor(float porcenComision,float totalVentas,String apellido,String dni,String email,String nombre,float sueldoBase)
	{
		super(apellido,dni,email,nombre,sueldoBase);
		this.porcenComision = porcenComision;
		this.totalVentas = totalVentas;
	}
	float getSueldo()
	{
		float sueldo;
		sueldo=this.getSueldoBase()+(this.getPorcenComision()*this.getTotalVentas()/100);
		return(sueldo);
	}
}
