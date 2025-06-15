package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AutorDTO; // Importación de la clase DTO para manejar los datos de autores
import util.Conexion; // Importación de la clase que gestiona la conexión con la base de datos

public class AutorDAO {

	// Método para insertar un autor en la base de datos
	public void insertarAutor(AutorDTO autor) {
		String sql = "INSERT INTO autor (nombre, pais) VALUES (?, ?)"; // Sentencia SQL para insertar un autor
		
		try (Connection conexion = Conexion.obtenerConexion(); // Obtener conexión a la base de datos
				PreparedStatement stmt = conexion.prepareStatement(sql)) { // Preparar la sentencia SQL

			// Asignar valores a los parámetros de la consulta
			stmt.setString(1, autor.getNombre());
			stmt.setString(2, autor.getPais());

			int filas = stmt.executeUpdate(); // Ejecutar la consulta y obtener número de filas afectadas

			// Verificar si fue exitosa
			if (filas > 0)
				System.out.println("Autor insertado correctamente.");
			else
				System.out.println("No se pudo insertar el autor.");

		} catch (SQLException e) {
			e.printStackTrace(); // Manejo de errores en caso de excepción SQL
		}
	}

	// Método para obtener la lista de autores desde la base de datos
	public List<AutorDTO> obtenerAutores() {
		List<AutorDTO> listaAutores = new ArrayList<>(); // Lista para almacenar los autores obtenidos
		String sql = "SELECT * FROM autor"; // Consulta SQL para obtener todos los autores

		try (Connection conexion = Conexion.obtenerConexion(); // Obtener conexión a la base de datos
				PreparedStatement stmt = conexion.prepareStatement(sql); // Preparar la consulta SQL
				ResultSet rs = stmt.executeQuery()) { // Ejecutar la consulta y obtener resultados

			// Iterar sobre el resultado y crear objetos AutorDTO
			while (rs.next()) {
				int id = rs.getInt("id_autor");
				String nombre = rs.getString("nombre");
				String pais = rs.getString("pais");
				listaAutores.add(new AutorDTO(id, nombre, pais)); // Agregar el autor a la lista
			}
		} catch (SQLException e) {
			System.out.println("Error al obtener autores.");
			e.printStackTrace(); // Manejo de errores en caso de excepción SQL
		}
		return listaAutores; // Retornar la lista de autores obtenida
	}
}