package ui;
import java.util.Scanner;
import entidades.*;
import logica.*;
public class Interfaz {
	Persona p=new Persona();
	Controlador l=new Controlador();
	public void crearPersona(){
		Scanner s=new Scanner(System.in);
		System.out.println("Ingrese habilitado (1true/0false): ");
		int h=s.nextInt();
		boolean habilitado;
		if(h==1)
		{
			habilitado= true;
		}
		else
		{
			habilitado= false;
		}
		s.nextLine();
		System.out.println("Ingrese nombre: ");
		String nombre=s.nextLine();
		System.out.println("Ingrese apellido: ");
		String apellido=s.nextLine();
		System.out.println("Ingrese dni: ");
		String dni=s.nextLine();
		this.cargaDatos(nombre,apellido,dni,habilitado,p);
		l.agregaPersona(p);
	}
	public void borrarPersona()
	{
		String dni=this.leeDni();
		int b=l.borraPersona(dni);
		if (b==0){System.out.println("no existe la persona a borrar");}
	}
	public void modificarPersona()
	{
		String dni2=this.leeDni();
		int a=l.modificaPersona(dni2);
		if(a==1)
		{
			System.out.println("Ingrese datos nuevos:");
			this.crearPersona();
		}
		else
		{
			System.out.println("No existe la pesona a modificar");
		}
	}
	public void mostrarPersona()
	{
		String dni1=this.leeDni();
		Persona x=l.muestraPersona(dni1);
		if(x!=null)
			this.muestra(x);
		else
			System.out.println("No existe la persona a mostrar");
	}
	public void menu()
	{
		
		Scanner s=new Scanner(System.in);
		int op;
		do
		{
			System.out.println("1_Crear 2_Borrar 3_Modificar 4_Mostrar 0_Salir");
			op=s.nextInt();
			switch (op) {
			case 1:
				this.crearPersona();
				break;
			case 2:
				this.borrarPersona();
				break;
			case 3:
				this.modificarPersona();
				break;
			case 4:
				this.mostrarPersona();
				break;
			default:
				break;
			
		}}
		while(op!=0);
	}
	public String leeDni()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Ingrese DNI a buscar: ");
		String dni=s.nextLine();
		return(dni);
	}
	public void cargaDatos(String nombre,String apellido,String dni,boolean habilitado,Persona p)
	{
		p.setNombre(nombre);
		p.setApellido(apellido);
		p.setDni(dni);
		p.setHabilitado(habilitado);
	}
	public void muestra(Persona p)
	{
		System.out.println(p.getApellido()+" "+p.getNombre()+" "+p.getDni());
		if(p.isHabilitado()==true)
			System.out.println("Habilitado");
		else
			System.out.println("No habilitado");
	}
}	
