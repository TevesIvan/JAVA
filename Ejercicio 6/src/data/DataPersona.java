package data;

import java.util.ArrayList;
import java.sql.*;

import entity.*;

public class DataPersona {
	
	public ArrayList<Persona> getAll(){
	
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from persona");
			if(rs!=null){
				while(rs.next()){
					Persona p=new Persona();
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					pers.add(p);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return pers;
		
	}
	
	public void add(Persona p){
		
		PreparedStatement stmt =null;
		
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(		
					"insert into persona values (?,?,?,?)");
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getApellido());
			stmt.setString(3, p.getDni());
			stmt.setBoolean(4, p.isHabilitado());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public Persona getByDni(Persona per){
		Persona p=null;
		ResultSet rs=null;
		PreparedStatement stmt =null;
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(		
					"select nombre, apellido, dni, habilitado from persona where dni=?");
			stmt.setString(1, per.getDni());
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()){
				p=new Persona();
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDni(rs.getString("dni"));
				p.setHabilitado(rs.getBoolean("habilitado"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}
	
	public void delete(Persona p)
	{
		PreparedStatement stmt =null;
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(		
					"delete from persona where dni=?");
			stmt.setString(1, p.getDni());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}