import java.sql.Date;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private static ArrayList<Prestamo> prestamos = new ArrayList<>();
    private static LinkedList<Libro> librosDisponibles = new LinkedList<>();

    public static void main(String[] args) {
        // Inicializar libros de prueba
        inicializarLibros();
        agregarPrestamoDePrueba();

        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 8) {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarPrestamo(scanner);
                    break;
                case 2:
                    consultarPrestamo(scanner);
                    break;
                case 3:
                    consultarPrestamosVencidos();
                    break;
                case 4:
                    modificarLibro(scanner);
                    break;
                case 5:
                    eliminarPrestamo(scanner);
                    break;
                case 6:
                    verLibrosPrestados();
                    break;
                case 7:
                    verLibrosPorGenero(scanner);
                    break;
                case 8:
                    guardarDatosPrestamos();
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        }
        scanner.close();
    }

    // Método que muestra el menú de opciones
    private static void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Registrar un préstamo");
        System.out.println("2. Consultar un préstamo específico (por ID)");
        System.out.println("3. Consultar todos los préstamos vencidos");
        System.out.println("4. Modificar la información de un libro específico");
        System.out.println("5. Eliminar un préstamo");
        System.out.println("6. Ver cuántos libros están prestados");
        System.out.println("7. Ver todos los libros de un género específico");
        System.out.println("8. Salir");
    }

    // Método para registrar un préstamo
    private static void registrarPrestamo(Scanner scanner) {
        System.out.println("Ingrese su nombre de usuario:");
        String usuario = scanner.nextLine();

        System.out.println("Libros disponibles:");
        for (int i = 0; i < librosDisponibles.size(); i++) {
            System.out.println(i + 1 + ". " + librosDisponibles.get(i).toString());
        }

        System.out.println("¿Cuántos libros desea prestar?");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        ArrayList<Libro> libros = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Seleccione el número del libro que desea prestar:");
            int libroIndex = scanner.nextInt() - 1;
            libros.add(librosDisponibles.get(libroIndex));
        }

        System.out.println("Ingrese el estado del préstamo (NUEVO, BUENO, REGULAR, MALO):");
        EstadoPrestamo estado = EstadoPrestamo.valueOf(scanner.next().toUpperCase());

        Prestamo prestamo = new Prestamo(prestamos.size() + 1, usuario, libros, new Date(System.currentTimeMillis()), estado);
        prestamos.add(prestamo);

        System.out.println("Préstamo registrado exitosamente.");
    }

    // Método para consultar un préstamo por ID
    private static void consultarPrestamo(Scanner scanner) {
        System.out.println("Ingrese el ID del préstamo a consultar:");
        int id = scanner.nextInt();

        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getId() == id) {
                System.out.println(prestamos.get(i).toString());
                return;
            }
        }
        System.out.println("No se encontró ningún préstamo con el ID: " + id);
    }

    // Método para consultar préstamos vencidos
    private static void consultarPrestamosVencidos() {
        Date hoy = new Date(System.currentTimeMillis());
        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getFechaDevolucion().before(hoy)) {
                System.out.println(prestamos.get(i).toString());
            }
        }
    }
// Método para modificar la información de un libro específico en un préstamo
private static void modificarLibro(Scanner scanner) {
    System.out.println("Ingrese el ID del préstamo a modificar:");
    int id = scanner.nextInt();

    // Buscar el préstamo por ID
    for (int i = 0; i < prestamos.size(); i++) {
        if (prestamos.get(i).getId() == id) {
            // Mostrar libros actuales en el préstamo
            System.out.println("Libros en este préstamo:");
            for (int j = 0; j < prestamos.get(i).getLibros().size(); j++) {
                System.out.println(j + 1 + ". " + prestamos.get(i).getLibros().get(j).toString());
            }

            // Seleccionar el libro a modificar
            System.out.println("Seleccione el número del libro que desea modificar:");
            int libroIndex = scanner.nextInt() - 1;
            Libro libroAModificar = prestamos.get(i).getLibros().get(libroIndex);

            // Menú de opciones para modificar los atributos del libro
            System.out.println("Seleccione el atributo que desea modificar:");
            System.out.println("1. Título");
            System.out.println("2. Autor");
            System.out.println("3. Año de publicación");
            System.out.println("4. Géneros");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Modificar título
                    System.out.println("Ingrese el nuevo título:");
                    String nuevoTitulo = scanner.nextLine();
                    libroAModificar.setTitulo(nuevoTitulo);
                    break;

                case 2:
                    // Modificar autor
                    System.out.println("Ingrese el nuevo autor:");
                    String nuevoAutor = scanner.nextLine();
                    libroAModificar.setAutor(nuevoAutor);
                    break;

                case 3:
                    // Modificar año de publicación
                    System.out.println("Ingrese el nuevo año de publicación:");
                    int nuevoAnio = scanner.nextInt();
                    libroAModificar.setAnioPublicacion(nuevoAnio);
                    break;

                case 4:
                    // Modificar géneros
                    LinkedList<Genero> nuevosGeneros = new LinkedList<>();
                    System.out.println("Ingrese el número de géneros a añadir:");
                    int numGeneros = scanner.nextInt();
                    scanner.nextLine();  // Limpiar buffer

                    for (int k = 0; k < numGeneros; k++) {
                        System.out.println("Seleccione el género (FICCION, NO_FICCION, CIENCIA, HISTORIA, FANTASIA):");
                        Genero genero = Genero.valueOf(scanner.nextLine().toUpperCase());
                        nuevosGeneros.add(genero);
                    }
                    libroAModificar.setGeneros(nuevosGeneros);
                    break;

                default:
                    System.out.println("Opción no válida.");
                    return;
            }

            System.out.println("Libro modificado exitosamente.");
            return;
        }
    }
    System.out.println("No se encontró ningún préstamo con el ID: " + id);
}


    // Método para eliminar un préstamo
    private static void eliminarPrestamo(Scanner scanner) {
        System.out.println("Ingrese el ID del préstamo a eliminar:");
        int id = scanner.nextInt();

        for (int i = 0; i < prestamos.size(); i++) {
            if (prestamos.get(i).getId() == id) {
                prestamos.remove(i);
                System.out.println("Préstamo eliminado exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró ningún préstamo con el ID: " + id);
    }

    // Método para ver cuántos libros están prestados
    private static void verLibrosPrestados() {
        int totalLibrosPrestados = 0;
        for (int i = 0; i < prestamos.size(); i++) {
            totalLibrosPrestados += prestamos.get(i).getLibros().size();
        }
        System.out.println("Total de libros prestados: " + totalLibrosPrestados);
    }

// Método para ver libros por género
    private static void verLibrosPorGenero(Scanner scanner) {
        System.out.println("Ingrese el género a consultar (FICCION, NO_FICCION, CIENCIA, HISTORIA, FANTASIA):");
        Genero genero = Genero.valueOf(scanner.next().toUpperCase());

        boolean libroEncontrado = false; // Bandera para saber si se encontró algún libro

        // Recorremos todos los préstamos
        for (int i = 0; i < prestamos.size(); i++) {
            // Recorremos los libros en cada préstamo
            for (int j = 0; j < prestamos.get(i).getLibros().size(); j++) {
                Libro libro = prestamos.get(i).getLibros().get(j);
                LinkedList<Genero> generosLibro = libro.getGeneros();

                // Revisar si el libro contiene el género buscado
                boolean generoCoincide = false;
                for (int k = 0; k < generosLibro.size(); k++) {
                    if (generosLibro.get(k).equals(genero)) {
                        generoCoincide = true;
                        break; // Romper el bucle si encontramos el género
                    }
                }

                // Imprimir solo si el género coincide
                if (generoCoincide) {
                    System.out.println(libro.toString());
                    libroEncontrado = true;
                }
            }
        }

        if (!libroEncontrado) {
            System.out.println("No se encontraron libros con el género: " + genero);
        }
    }

    // Método para inicializar 10 libros de prueba
    private static void inicializarLibros() {
        LinkedList<Genero> generos1 = new LinkedList<>();
        generos1.add(Genero.FICCION);
        generos1.add(Genero.HISTORIA);
        librosDisponibles.add(new Libro("El Señor de los Anillos", "J.R.R. Tolkien", generos1, 1954));

        LinkedList<Genero> generos2 = new LinkedList<>();
        generos2.add(Genero.CIENCIA);
        librosDisponibles.add(new Libro("Breve historia del tiempo", "Stephen Hawking", generos2, 1988));

        LinkedList<Genero> generos3 = new LinkedList<>();
        generos3.add(Genero.FICCION);
        generos3.add(Genero.FANTASIA);
        librosDisponibles.add(new Libro("Harry Potter y la piedra filosofal", "J.K. Rowling", generos3, 1997));

        LinkedList<Genero> generos4 = new LinkedList<>();
        generos4.add(Genero.HISTORIA);
        generos4.add(Genero.NO_FICCION);
        librosDisponibles.add(new Libro("Sapiens", "Yuval Noah Harari", generos4, 2011));

        LinkedList<Genero> generos5 = new LinkedList<>();
        generos5.add(Genero.FICCION);
        generos5.add(Genero.FANTASIA);
        librosDisponibles.add(new Libro("Juego de Tronos", "George R.R. Martin", generos5, 1996));

        LinkedList<Genero> generos6 = new LinkedList<>();
        generos6.add(Genero.CIENCIA);
        librosDisponibles.add(new Libro("El gen egoísta", "Richard Dawkins", generos6, 1976));

        LinkedList<Genero> generos7 = new LinkedList<>();
        generos7.add(Genero.NO_FICCION);
        generos7.add(Genero.HISTORIA);
        librosDisponibles.add(new Libro("Guns, Germs, and Steel", "Jared Diamond", generos7, 1997));

        LinkedList<Genero> generos8 = new LinkedList<>();
        generos8.add(Genero.FANTASIA);
        librosDisponibles.add(new Libro("El hobbit", "J.R.R. Tolkien", generos8, 1937));

        LinkedList<Genero> generos9 = new LinkedList<>();
        generos9.add(Genero.HISTORIA);
        librosDisponibles.add(new Libro("1776", "David McCullough", generos9, 2005));

        LinkedList<Genero> generos10 = new LinkedList<>();
        generos10.add(Genero.NO_FICCION);
        generos10.add(Genero.CIENCIA);
        librosDisponibles.add(new Libro("Cosmos", "Carl Sagan", generos10, 1980));
    }


    // Método para guardar los datos de los préstamos en un archivo txt
    private static void guardarDatosPrestamos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("prestamos.txt"))) {
            for (int i = 0; i < prestamos.size(); i++) {
                writer.write(prestamos.get(i).toString());
                writer.newLine();
            }
            System.out.println("Datos guardados exitosamente en prestamos.txt");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar los datos: " + e.getMessage());
        }
    }
    private static void agregarPrestamoDePrueba() {
        // Obtener la fecha actual en milisegundos
        long fechaActualMillis = System.currentTimeMillis();
    
        // Calcular la fecha de préstamo restando 7 días (7 días * 24 horas * 60 minutos * 60 segundos * 1000 milisegundos)
        long fechaPrestamoMillis = fechaActualMillis - (7L * 24 * 60 * 60 * 1000);
        Date fechaPrestamo = new Date(fechaPrestamoMillis);
    
        // Crear un libro de ejemplo
        LinkedList<Genero> generosLibro = new LinkedList<>();
        generosLibro.add(Genero.FICCION);
        Libro libro = new Libro("Libro de Prueba", "Autor de Ejemplo", generosLibro, 2022);
    
        // Crear lista de libros y agregar el libro de ejemplo
        ArrayList<Libro> libros = new ArrayList<>();
        libros.add(libro);
    
        // Crear el préstamo y añadirlo a la lista de préstamos
        Prestamo prestamo = new Prestamo(1, "UsuarioPrueba", libros, fechaPrestamo, EstadoPrestamo.BUENO);
        prestamos.add(prestamo);
    
        System.out.println("Préstamo de prueba agregado con fecha de vencimiento hoy.");
    }
    
}
