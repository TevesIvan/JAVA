package logica;
import entidades.*;
import ui.*;
import java.util.ArrayList;

 public class Controlador {
	 Interfaz c;
	ArrayList<Persona> personas=new ArrayList<Persona>();
	public void agregaPersona(Persona p)
	{
		personas.add(p);
	}
	public int borraPersona(String dni)
	{int b=0;
		for (Persona persona : personas) {
			if((persona.getDni()).equals(dni))
			{
				personas.remove(persona);
				b=1;
				break;
			}

		} return(b);
	}
	public Persona muestraPersona(String dni){
		for (Persona persona : personas) {
			if((persona.getDni()).equals(dni))
			{
				return(persona);
			}
		}
		return(null);
	}
	public int modificaPersona(String dni){
		int b=this.borraPersona(dni);
		return(b);
	}
	
}
