package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.LibroDTO; // Clase DTO para representar los datos de un libro
import util.Conexion; // Clase que maneja la conexión con la base de datos

public class LibroDAO {

	// Método para insertar un nuevo libro en la base de datos	
	public void insertarLibro(LibroDTO libro) {
		String sql = "INSERT INTO libro (titulo, anio, id_autor) VALUES (?, ?, ?)"; // Consulta SQL para insertar un libro
		
		try (Connection conexion = Conexion.obtenerConexion(); // Obtener conexión a la base de datos
				PreparedStatement stmt = conexion.prepareStatement(sql)) { // Preparar la consulta SQL

			// Asignar valores a los parámetros de la consulta
			stmt.setString(1, libro.getTitulo());
			stmt.setInt(2, libro.getAnio());
			stmt.setInt(3, libro.getIdAutor());

			int filas = stmt.executeUpdate(); // Ejecutar la consulta y obtener número de filas afectadas

			// Verificar si la inserción fue exitosa
			if (filas > 0)
				System.out.println("Libro insertado correctamente.");
			else
				System.out.println("No se pudo insertar el libro.");
		} catch (SQLException e) {
			e.printStackTrace(); // Manejo de errores en caso de excepción SQL
		}
	}

	// Método para obtener la lista de libros desde la base de datos
	public List<LibroDTO> obtenerLibros() {
		List<LibroDTO> listaLibros = new ArrayList<>(); // Lista para almacenar los libros obtenidos
		String sql = "SELECT * FROM libro"; // Consulta SQL para obtener todos los libros

		try (Connection conexion = Conexion.obtenerConexion(); // Obtener conexión a la base de datos
				PreparedStatement stmt = conexion.prepareStatement(sql); // Preparar la consulta SQL
				ResultSet rs = stmt.executeQuery()) { // Ejecutar la consulta y obtener resultados

			// Iterar sobre los resultados y crear objetos LibroDTO
			while (rs.next()) {
				int idLibro = rs.getInt("id_libro");
				String titulo = rs.getString("titulo");
				int anio = rs.getInt("anio");
				int idAutor = rs.getInt("id_autor");
				listaLibros.add(new LibroDTO(idLibro, titulo, anio, idAutor)); // Agregar el libro a la lista
			}
		} catch (SQLException e) {
			System.out.println("Error al obtener libros.");
			e.printStackTrace(); // Manejo de errores en caso de excepción SQL
		}
		return listaLibros; // Retornar la lista de libros obtenida
	}

	// Método para modificar el título de un libro dado su id
	public void modificarTituloLibro(int idLibro, String nuevoTitulo) {
		String sql = "UPDATE libro SET titulo = ? WHERE id_libro = ?"; // Consulta SQL para actualizar el título
		
		try (Connection conexion = Conexion.obtenerConexion(); // Obtener conexión a la base de datos
				PreparedStatement stmt = conexion.prepareStatement(sql)) { // Preparar la consulta SQL

			stmt.setString(1, nuevoTitulo); // Asignar el nuevo título
			stmt.setInt(2, idLibro); // Asignar el ID del libro

			int filas = stmt.executeUpdate(); // Ejecutar la consulta

			// Verificar si la actualización fue exitosa
			if (filas > 0)
				System.out.println("Título modificado correctamente.");
			else
				System.out.println("No se encontró el libro a modificar.");
		} catch (SQLException e) {
			System.out.println("Error al modificar el título del libro.");
			e.printStackTrace(); // Manejo de errores en caso de excepción SQL
		}
	}

	// Método para eliminar un libro dado su id
	public void eliminarLibro(int idLibro) {
		String sql = "DELETE FROM libro WHERE id_libro = ?"; // Consulta SQL para eliminar un libro
		
		try (Connection conexion = Conexion.obtenerConexion(); // Obtener conexión a la base de datos
				PreparedStatement stmt = conexion.prepareStatement(sql)) { // Preparar la consulta SQL

			stmt.setInt(1, idLibro); // Asignar el ID del libro a eliminar
			int filas = stmt.executeUpdate(); // Ejecutar la consulta

			// Verificar si la eliminación fue exitosa
			if (filas > 0)
				System.out.println("Libro eliminado correctamente.");
			else
				System.out.println("No se encontró el libro a eliminar.");
		} catch (SQLException e) {
			System.out.println("Error al eliminar libro.");
			e.printStackTrace(); // Manejo de errores en caso de excepción SQL
		}
	}
}