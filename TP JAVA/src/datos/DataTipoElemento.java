package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.*;
import util.AppDataException;

public class DataTipoElemento {
	public ArrayList<TipoElemento> getAll() throws Exception{
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<TipoElemento> tip= new ArrayList<TipoElemento>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from tipo_elemento t");
			if(rs!=null){
				while(rs.next()){
					TipoElemento t=new TipoElemento();
					t.setId(rs.getInt("idTipoElemento"));
					t.setNombre(rs.getString("nombre"));
					t.setCantMax(rs.getInt("cantMax"));
					tip.add(t);
				}
			}
		} catch (SQLException e) {
			
			throw e;
		} catch (AppDataException ade){
			throw ade;
		}
		

		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			throw e;
		}
		
		return tip;
	}
	
	public void add(TipoElemento t) throws Exception{
		
		PreparedStatement stmt =null;
		ResultSet keyResultSet=null;
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(		
					"insert into tipo_elemento(idTipoElemento,nombre,cantMax) values (?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(2, t.getNombre());
			stmt.setInt(3, t.getCantMax());
			stmt.setInt(1, t.getId());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				t.setId(keyResultSet.getInt(1));
			}
		} catch (SQLException | AppDataException e) {
			throw e;
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			throw e;
		}
		
	}
	
	public void delete(TipoElemento t) throws Exception
	{
		PreparedStatement stmt =null;
		try {
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement(		
					"delete from tipo_elemento where id=?");
			stmt.setInt(1, t.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw e;
		}
		try {
			
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			
			throw e;
		}
	}
}
