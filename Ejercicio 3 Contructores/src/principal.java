import java.util.ArrayList;
import java.util.Scanner;
public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner teclado=new Scanner(System.in);
		int op,rta;
		ArrayList<Empleado>empleados=new ArrayList<Empleado>();
		do{
			System.out.println("Ingrese Tipo de Empleado 1-Administrativo 2-Vendedor");
			op=teclado.nextInt();
			teclado.nextLine();
			System.out.println("Ingrese Apellido: ");
			String apellido=teclado.nextLine();
			System.out.println("Ingrese Nombre: ");
			String nombre=teclado.nextLine();
			System.out.println("Ingrese dni: ");
			String dni=teclado.nextLine();
			System.out.println("Ingrese email: ");
			String email=teclado.nextLine();
			System.out.println("Ingrese Sueldo Base: ");
			Float sueldoBase=teclado.nextFloat();
			if(op==1)
			{
				System.out.println("Ingrese hsExtra: ");
				int hsExtra=teclado.nextInt();
				System.out.println("Ingrese hsMes: ");
				int hsMes=teclado.nextInt();
				Administrativo emp=new Administrativo(hsExtra,hsMes,apellido,dni,email,nombre,sueldoBase);
				//emp.cargaDatos(hsExtra,hsMes,apellido,dni,email,nombre,sueldoBase);
				empleados.add(emp);
			}
			else if(op==2)
			{
				System.out.println("Ingrese porcenComision: ");
				float porcenComision=teclado.nextFloat();
				System.out.println("Ingrese totalVentas: ");
				float totalVentas=teclado.nextFloat();
				//emp.cargaDatos(porcenComision,totalVentas,apellido,dni,email,nombre,sueldoBase);
				Vendedor emp=new Vendedor(porcenComision,totalVentas,apellido,dni,email,nombre,sueldoBase);
				empleados.add(emp);

			}
			else
			{
				System.out.println("Opcion Incorrecta.");
			}
			System.out.println("¿Desea seguir ingresando empleados? 1-Si 2-No");
			rta=teclado.nextInt();
		}
		while(rta==1);
		for(Empleado emp:empleados)
		{
			System.out.println("Empleado: "+" "+emp.getApellido()+" "+emp.getNombre()+" "+emp.getDni());
			System.out.println("sueldo: " + emp.getSueldo());
		}
		teclado.close();
	}
	

}
