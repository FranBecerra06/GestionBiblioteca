package util;

import java.util.*;

import dao.AutorDAO;
import dao.LibroDAO;
import dto.AutorDTO;
import dto.LibroDTO;

public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		AutorDAO autorDao = new AutorDAO();
		LibroDAO libroDao = new LibroDAO();
		int opcion;

		do {
			System.out.println("\n=== Gestión de Biblioteca ===");
			System.out.println("1. Insertar autor");
			System.out.println("2. Ver autores");
			System.out.println("3. Insertar libro");
			System.out.println("4. Ver libros");
			System.out.println("5. Modificar título de un libro");
			System.out.println("6. Eliminar un libro");
			System.out.println("0. Salir");
			System.out.print("Seleccione opción: ");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {

			case 1:

				System.out.println("Introduzca el nombre del autor: ");
				String nombreAutor = sc.nextLine();

				System.out.println("Introduzca la nacionalidad: ");
				String paisAutor = sc.nextLine();

				AutorDTO autor = new AutorDTO(0, nombreAutor, paisAutor);
				autorDao.insertarAutor(autor);
				System.out.println("Autor creado con exito.");

				break;
			case 2:
				List<AutorDTO> listaAutores = autorDao.obtenerAutores();

				System.out.println("Listado de los autores: ");
				if (!listaAutores.isEmpty()) {
					for (AutorDTO a : listaAutores) {

						System.out.println(a.getIdAutor() + " " + a.getNombre() + " " + a.getPais());
					}
				} else {
					System.out.println("La lista está vacía.");
				}

				break;

			case 3:

				System.out.println("Introduzca el nombre del libro: ");
				String nombreLibro = sc.nextLine();

				System.out.println("Introduce el año del libro: ");
				int anio = sc.nextInt();

				System.out.println("Introduzca la id del Autor: ");
				int idAutorlibro = sc.nextInt();

				LibroDTO libro = new LibroDTO(0, nombreLibro, anio, idAutorlibro);
				libroDao.insertarLibro(libro);
				System.out.println("Libro creado con exito.");

				break;
			case 4:
				List<LibroDTO> listaLibros = libroDao.obtenerLibros();

				System.out.println("Lista de los libros creados: ");
				if (!listaLibros.isEmpty()) {

					for (LibroDTO l : listaLibros) {

						System.out.println("Autor numero: " + l.getIdAutor() + " / " + l.getIdLibro() + " "
								+ l.getTitulo() + "(" + l.getAnio() + ")");
					}
				} else {

					System.out.println("La lista está vacía.");
				}

				break;

			case 5:

				System.out.println("Introduce el id del libro que desea modificar: ");
				int idLibroModificar = sc.nextInt();

				sc.nextLine();
				System.out.println("Introduce el nuevo titulo del libro: ");
				String nuevoTitulo = sc.nextLine();

				libroDao.modificarTituloLibro(idLibroModificar, nuevoTitulo);

				break;
			case 6:

				System.out.println("Introduce el id del libro que desea eliminar: ");
				int idLibroEliminar = sc.nextInt();

				sc.nextLine();
				libroDao.eliminarLibro(idLibroEliminar);

				break;

			case 0:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opcion no vali2da, intente otra opcion.");

			}

		} while (opcion != 0);

		sc.close();

	}
}
