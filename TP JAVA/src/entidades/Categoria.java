package entidades;

public class Categoria {
	public String idCategoria,nombre;
	
	public String toString()
	{
		String mensaje=this.nombre;
		return mensaje;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
