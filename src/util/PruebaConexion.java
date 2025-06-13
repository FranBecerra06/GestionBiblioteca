package util;

import java.sql.Connection;
import java.sql.SQLException;

public class PruebaConexion {
    public static void main(String[] args) {
        // Intentar obtener la conexión
        try (Connection conexion = Conexion.obtenerConexion()) {
            if (conexion != null) {
                System.out.println("¡Conexión exitosa a la base de datos!");
            } else {
                System.out.println("Error al conectar a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Excepción al conectar a la base de datos:");
            e.printStackTrace();
        }
    }
}

