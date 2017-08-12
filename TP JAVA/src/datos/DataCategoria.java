package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entidades.Categoria;

public class DataCategoria {
public static Categoria[] getAll(){
		
	    int i=0;
		Statement stmt=null;
		ResultSet rs=null;
		Categoria[] cate= new Categoria[3];
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from categoria");
			if(rs!=null){
				while(rs.next()){
					Categoria c=new Categoria();
					c.setIdCategoria(rs.getInt("idCategoria"));
					c.setNombre(rs.getString("nombre"));
					cate[i++]=c;
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
		
		return cate;
		
	}
}
