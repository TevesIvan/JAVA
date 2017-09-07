package datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;


import entidades.Elemento;
import entidades.Reserva;
import entidades.Reserva.Estado;
import entidades.TipoElemento;
import util.AppDataException;

public class DataReserva {

	public void registrarReserva(Reserva r) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Elemento> buscaElementosDisp(Reserva r) throws Exception{
		
		PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Elemento> ele= new ArrayList<Elemento>();
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"select e.idElemento,e.nombre,t.idTipoElemento from elemento e inner join tipo_elemento t on e.idTipoElemento=t.idTipoElemento where t.nombre=? and e.idElemento not in(select e.idElemento from elemento e inner join reserva r on r.idElemento=e.idElemento where ((? between r.fechaHoraDesde and r.fechaHoraHasta) or (? between r.fechaHoraDesde and r.fechaHoraHasta)or(?<r.fechaHoraDesde and ?>r.fechaHoraHasta))and (r.estado=? or r.estado=?))");
			stmt.setString(1,r.getElemento().getTipoElemento().getNombre());
			stmt.setDate(2,r.getFechaHoraDesde());
			stmt.setDate(3,r.getFechaHoraHasta());
			stmt.setDate(4,r.getFechaHoraDesde());
			stmt.setDate(5,r.getFechaHoraHasta());
			stmt.setString(6,"Reservado");
			stmt.setString(7,"Comenzado");
			rs=stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					Elemento e=new Elemento();
					e.setTipoElemento(new TipoElemento());
					e.setNombre(rs.getString("e.nombre"));
					e.setId(rs.getInt("e.idElemento"));
					e.getTipoElemento().setId(rs.getInt("t.idTipoElemento"));
					e.getTipoElemento().setNombre(rs.getString("t.nombre"));
					e.getTipoElemento().setCantMax(rs.getInt("t.cantMax"));
					ele.add(e);
				}
			}
		} catch (Exception e) {
			throw e;
		} finally{
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {
				
				throw e;
			}
		}
		return ele;
		}

}
