package controlador;

import java.util.ArrayList;

import datos.DataReserva;
import datos.DataTipoElemento;
import entidades.Elemento;
import entidades.Reserva;
import entidades.TipoElemento;

public class CtrlReserva {
	private DataReserva dataRes;
	private DataTipoElemento dataTip;
	
	public CtrlReserva(){
		dataRes=new DataReserva();
		dataTip=new DataTipoElemento();
	}
	

	public ArrayList<TipoElemento> getTiposElementos() throws Exception {
		return dataTip.getAll();
	}


	public void registrarReserva(Reserva r) {
		dataRes.registrarReserva(r);
	}


	public ArrayList<Elemento> buscaElementosDisp(Reserva r) throws Exception {
		return dataRes.buscaElementosDisp(r);
	}
}
