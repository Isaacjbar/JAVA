import java.util.Scanner;

public class BibliotecaApp {
    private LinkedListA<Libro> biblioteca = new LinkedListA<>();
    private Scanner scanner = new Scanner(System.in);

    public void agregarLibro() {
        System.out.println("Ingrese el título del libro:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el autor del libro:");
        String autor = scanner.nextLine();
        System.out.println("Ingrese el año de publicación del libro:");
        int añoPublicacion = Integer.parseInt(scanner.nextLine());

        Libro libro = new Libro(titulo, autor, añoPublicacion);
        biblioteca.add(libro);
        System.out.println("Libro agregado exitosamente.");
    }

    public void buscarLibrosPorAutor() {
        System.out.println("Ingrese el autor que desea buscar:");
        String autor = scanner.nextLine();

        System.out.println("Libros del autor '" + autor + "':");
        for (int i = 0; i < biblioteca.size(); i++) {
            Libro libro = biblioteca.get(i);
            if (libro.getAutor().equalsIgnoreCase(autor)) {
                System.out.println(libro);
            }
        }
    }

    public void filtrarLibrosPorAño() {
        System.out.println("Ingrese el año límite:");
        int año = Integer.parseInt(scanner.nextLine());

        System.out.println("Libros publicados antes de " + año + ":");
        for (int i = 0; i < biblioteca.size(); i++) {
            Libro libro = biblioteca.get(i);
            if (libro.getAñoPublicacion() < año) {
                System.out.println(libro);
            }
        }
    }

    public void modificarLibro() {
        System.out.println("Ingrese el título del libro a modificar:");
        String titulo = scanner.nextLine();

        for (int i = 0; i < biblioteca.size(); i++) {
            Libro libro = biblioteca.get(i);
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Ingrese el nuevo título:");
                libro.setTitulo(scanner.nextLine());
                System.out.println("Ingrese el nuevo autor:");
                libro.setAutor(scanner.nextLine());
                System.out.println("Ingrese el nuevo año de publicación:");
                libro.setAñoPublicacion(Integer.parseInt(scanner.nextLine()));
                System.out.println("Libro modificado exitosamente.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    public void eliminarLibro() {
        System.out.println("Ingrese el título del libro a eliminar:");
        String titulo = scanner.nextLine();

        for (int i = 0; i < biblioteca.size(); i++) {
            Libro libro = biblioteca.get(i);
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                biblioteca.remove(i);
                System.out.println("Libro eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Libro no encontrado.");
    }

    public void mostrarLibros() {
        System.out.println("Libros en la biblioteca:");
        for (int i = 0; i < biblioteca.size(); i++) {
            System.out.println(biblioteca.get(i));
        }
    }

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nGestión de Biblioteca:");
            System.out.println("1. Agregar libro");
            System.out.println("2. Buscar libros por autor");
            System.out.println("3. Filtrar libros por año");
            System.out.println("4. Modificar libro");
            System.out.println("5. Eliminar libro");
            System.out.println("6. Mostrar todos los libros");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    app.agregarLibro();
                    break;
                case 2:
                    app.buscarLibrosPorAutor();
                    break;
                case 3:
                    app.filtrarLibrosPorAño();
                    break;
                case 4:
                    app.modificarLibro();
                    break;
                case 5:
                    app.eliminarLibro();
                    break;
                case 6:
                    app.mostrarLibros();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
    }
}
