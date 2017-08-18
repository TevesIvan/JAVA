package controlador;

import java.util.ArrayList;

import datos.DataTipoElemento;
import entidades.Persona;
import entidades.TipoElemento;

public class CtrlTipoElemento {
	private DataTipoElemento dataTip;
	
	public void add(TipoElemento t) throws Exception{
		dataTip.add(t);
	}
	
	public void delete(TipoElemento t) throws Exception{
		dataTip.delete(t);
	}
	
	public void update(TipoElemento t) throws Exception{
		dataTip.delete(t);
		dataTip.add(t);
	}
	
	public ArrayList<TipoElemento> getAll() throws Exception{
		return dataTip.getAll();
	}
}
