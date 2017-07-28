package controlador;

import java.util.ArrayList;

import datos.DataPersona;
import entidades.Persona;

public class CrtlABMCPersona {
	private DataPersona dataPer;
	
	private ArrayList<Persona> pers;
	
	
	public CrtlABMCPersona(){
		dataPer = new DataPersona();
		pers= new ArrayList<Persona>();
	}
	
	public void add(Persona p) {
		//this.pers.add(p);
		dataPer.add(p);
	}
	
	public void delete(Persona p){
		//this.pers.remove(this.getByDni(p));
		//this.pers.remove(p);
		dataPer.delete(p);
	}
	
	public void update(Persona p){
		//this.delete(p);
		//this.add(p);
		dataPer.delete(p);
		dataPer.add(p);
	}
	
	public Persona getByDni(Persona p){
		return dataPer.getByDni(p);
		//return this.getByDni(p.getDni());
	}
	
	public Persona getByDni(String dni){
		Persona p=new Persona();
		p.setDni(dni);
		return getByDni(p);
		/*for (int i=0; i < this.pers.size(); i++){
			if(pers.get(i).getDni().equals(dni)) {
				return pers.get(i);
				
			}
		}
		return null; //ver error si falta
		*/
	}
	
	public ArrayList<Persona> getAll(){
		//return this.pers;
		return dataPer.getAll();
	}
}
