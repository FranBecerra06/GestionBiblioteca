package dto;

public class LibroDTO {
	private int idLibro;
	private String titulo;
	private int idAutor;
	private int anio;

	public LibroDTO(int idLibro, String titulo, int anio, int idAutor) {
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.idAutor = idAutor;
		this.anio = anio;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

}