package entidades;

public class Categoria {
	public String nombre;
	public int idCategoria;
	
	@Override
	//public boolean equals(Object o){
	//	return (o instanceof Categoria && ((Categoria)o).getIdCategoria().equalsIgnoreCase(this.getIdCategoria()));
	//}
	
	public String toString()
	{
		String mensaje=this.nombre;
		return mensaje;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
