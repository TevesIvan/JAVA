package data;
import java.sql.Connection;
import java.sql.DriverManager;
public class FactoryConexion {

	private static FactoryConexion instancia;
	private FactoryConexion(){
		try {
			Class.forName("new com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static FactoryConexion getInstancia(){
		if(FactoryConexion.instancia==null){
			FactoryConexion.instancia=new FactoryConexion();
		}
		return FactoryConexion.instancia;
	}
	
	public Connection getConn(){
		return DriverManager.getConnection("")
	}
}
