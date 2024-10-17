import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AgendaContactos agenda = new AgendaContactos();
        int opcion;

        // Menú para gestionar contactos
        do {
            System.out.println("\nMenú de Gestión de Contactos:");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Mostrar todos los contactos");
            System.out.println("3. Buscar contacto por índice");
            System.out.println("4. Modificar número de teléfono");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Mostrar total de contactos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarContacto(scanner, agenda);
                    break;
                case 2:
                    agenda.mostrarContactos();
                    break;
                case 3:
                    buscarContactoPorIndice(scanner, agenda);
                    break;
                case 4:
                    modificarTelefono(scanner, agenda);
                    break;
                case 5:
                    eliminarContacto(scanner, agenda);
                    break;
                case 6:
                    System.out.println("Total de contactos: " + agenda.totalContactos());
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    // Método auxiliar para agregar contacto
    public static void agregarContacto(Scanner scanner, AgendaContactos agenda) {
        System.out.print("Ingrese el nombre del contacto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el número de teléfono: ");
        String telefono = scanner.nextLine();
        agenda.agregarContacto(new Contacto(nombre, telefono));
    }

    // Método auxiliar para buscar contacto por índice
    public static void buscarContactoPorIndice(Scanner scanner, AgendaContactos agenda) {
        System.out.print("Ingrese el índice del contacto a buscar: ");
        int indice = scanner.nextInt() - 1; // Restar 1 para ajustar al índice de la lista
        Contacto contacto = agenda.buscarContactoPorIndice(indice);
        if (contacto != null) {
            System.out.println("Contacto encontrado: " + contacto);
        }
    }

    // Método auxiliar para modificar el número de teléfono
    public static void modificarTelefono(Scanner scanner, AgendaContactos agenda) {
        System.out.print("Ingrese el índice del contacto a modificar: ");
        int indice = scanner.nextInt() - 1; // Restar 1 para ajustar al índice de la lista
        scanner.nextLine(); // Consumir el salto de línea
        System.out.print("Ingrese el nuevo número de teléfono: ");
        String nuevoTelefono = scanner.nextLine();
        agenda.modificarTelefono(indice, nuevoTelefono);
    }

    // Método auxiliar para eliminar un contacto
    public static void eliminarContacto(Scanner scanner, AgendaContactos agenda) {
        System.out.print("Ingrese el índice del contacto a eliminar: ");
        int indice = scanner.nextInt() - 1; // Restar 1 para ajustar al índice de la lista
        agenda.eliminarContacto(indice);
    }
}
