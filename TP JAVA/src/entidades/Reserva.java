package entidades;
import java.sql.Date;

public class Reserva {
	public java.util.Date fechaActual = new java.util.Date();
	public Date fechaHoraReserva,fechaHoraDesde,fechaHoraHasta;
	public int id;
	public Persona persona;
	public Elemento elemento;
	public String detalle;
	public String estado;

public Reserva(Persona p,Elemento e,String detalle,String estado, Date fechaHoraDesde, Date fechaHoraHasta){
	this.persona=p;
	this.elemento=e;
	this.detalle=detalle;
	this.estado=estado;
	this.fechaHoraDesde=fechaHoraDesde;
	this.fechaHoraHasta=fechaHoraHasta;
	this.fechaHoraReserva.getTime();
}
	
}

