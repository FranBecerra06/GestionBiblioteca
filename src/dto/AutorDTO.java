package dto;

public class AutorDTO {

	private int idAutor;
	private String nombre;
	private String pais;

	public int getIdAutor() {
		return idAutor;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPais() {
		return pais;
	}

	public String toString() {
		return "AutorDTO [idAutor=" + idAutor + ", nombre=" + nombre + ", pais=" + pais + "]";
	}

}
