package data;
import entidades.*;


import java.sql.ResultSet;
import java.util.*;
public class DataPersona {

	public ArrayList<Persona> getAll(){
		ArrayList<Persona> pers=new 
		java.sql.Statement stmt= FactoryConexion.getInstancia().getConn().createStatement();
		ResultSet rs=stmt.executeQuery("select* from persona");
		if(rs!=null){
			while(rs.next()){
				Persona p=new Persona();
				
				p.setNombre(; rs.getString("nombre"));
				p.setApellido(; rs.getString("apellido"));
				rs.getString("dni");
				rs.getBoolean("habilitado");
				
				pers.add(p);
			}
		}
	}
}
