package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import dto.AutorDTO;
import util.Conexion;

public class AutorDAO {

	// INSERTAR AUTOR

	public void insertarAutor(AutorDTO autor) {

		String sql = "INSERT INTO autor (id_autor, nombre, pais) VALUES (?, ?, ?)";

		try (Connection conexion = Conexion.obtenerConexion();
				PreparedStatement stmt = conexion.prepareStatement(sql)) {

			stmt.setString(1, autor.getNombre());
			stmt.setString(2, autor.getPais());
			stmt.setInt(3, autor.getIdAutor());
			stmt.executeUpdate();

			System.out.println("Autor creado correctamente.");

		} catch (SQLException e) {

			System.out.println("Error al crear el autor.");
			e.printStackTrace();

		}

	}

	// OBTENER LISTA AUTORES

	public List<AutorDTO> obtenerAutores() {

		List<AutorDTO> listaAutor = new ArrayList<>();

		String sql = "SELECT * FROM autor";

		try (Connection conexion = Conexion.obtenerConexion();
				Statement stmt = conexion.createStatement();

				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {

				// ATRIBUTOS DE LAS TABLAS DE LA BD
				listaAutor.add(new AutorDTO(rs.getInt("id_autor"), rs.getString("nombre"), rs.getString("pais")));

			}
		} catch (SQLException e) {

			e.printStackTrace();

		}

		return listaAutor;

	}

	// ACTUALIZAR AUTORES

	public void actualizarAutores(AutorDTO autor) {

		String sql = "UPDATE autor SET nombre = ?, pais = ? WHERE idAutor = ?";

		try (Connection conexion = Conexion.obtenerConexion();
				PreparedStatement stmt = conexion.prepareStatement(sql)) {

			stmt.setString(1, autor.getNombre());
			stmt.setString(2, autor.getPais());
			stmt.setInt(3, autor.getIdAutor());

			stmt.executeUpdate();

			System.out.println("Autor actualizado.");

		} catch (SQLException e) {

			System.out.println("Error al actualizar un autor");
			e.printStackTrace();
		}
	}

	// ELIMINAR AUTORES

	public void eliminarAutores(int idAutor) {

		String sql = "DELETE FROM autor WHERE id_autor = ?";

		try (Connection conexion = Conexion.obtenerConexion();
				PreparedStatement stmt = conexion.prepareStatement(sql)) {

			stmt.setInt(1, idAutor);

			stmt.executeUpdate();
			System.out.println("Autor eliminado.");

		} catch (SQLException e) {

			System.out.println("Error al eliminar un autor.");

			e.printStackTrace();

		}

	}

}
