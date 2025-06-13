package dto;

public class AutorDTO {

	private int idAutor;
	private String nombre;
	private String pais;

	public AutorDTO(int idAutor, String nombre, String pais) {
		this.idAutor = idAutor;
		this.nombre = nombre;
		this.pais = pais;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPais(String pais) {
		this.pais = pais;
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
