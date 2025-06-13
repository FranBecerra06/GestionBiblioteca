package dto;

public class LibroDTO {

	private int idLibro;
	private String titulo;
	private int anio;

	public LibroDTO(int idLibro, String titulo, int anio) {

		this.idLibro = idLibro;
		this.titulo = titulo;
		this.anio = anio;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getAnio() {
		return anio;
	}

	public String toString() {
		return "LibroDTO [idLibro=" + idLibro + ", titulo=" + titulo + ", anio=" + anio + "]";
	}

}
