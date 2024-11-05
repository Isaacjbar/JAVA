import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SistemaDevoluciones {

    private static final CircularLinkedList<Devolucion> listaDevoluciones = new CircularLinkedList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws IOException {
        boolean running = true;

        while (running) {
            System.out.println("\nMenú:");
            System.out.println("1. Registrar devolución de un coche");
            System.out.println("2. Ver todas las devoluciones realizadas hoy");
            System.out.println("3. Ver devoluciones de una fecha específica");
            System.out.println("4. Eliminar una devolución específica");
            System.out.println("5. Cambiar los detalles de una devolución");
            System.out.println("6. Ver todas las devoluciones de un coche de una marca específica");
            System.out.println("7. Salir del sistema y guardar");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarDevolucion();
                    break;
                case 2:
                    verDevolucionesHoy();
                    break;
                case 3:
                    verDevolucionesFecha();
                    break;
                case 4:
                    eliminarDevolucion();
                    break;
                case 5:
                    modificarDevolucion();
                    break;
                case 6:
                    verDevolucionesPorMarca();
                    break;
                case 7:
                    guardarYSalir();
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void registrarDevolucion() {
        System.out.println("Ingrese los detalles de la devolución:");

        System.out.print("ID de devolución: ");
        String id = scanner.nextLine();

        System.out.print("Marca del coche: ");
        String marca = scanner.nextLine();

        System.out.print("Modelo del coche: ");
        String modelo = scanner.nextLine();

        System.out.print("Serie del coche: ");
        String serie = scanner.nextLine();

        System.out.print("Color del coche (ROJO, VERDE, etc.): ");
        Color color = Color.valueOf(scanner.nextLine().toUpperCase());

        System.out.print("Motivo de devolución (FIN_ALQUILER, ACCIDENTE, etc.): ");
        Motivo motivo = Motivo.valueOf(scanner.nextLine().toUpperCase());

        Coche coche = new Coche(marca, modelo, serie, color);
        Devolucion devolucion = new Devolucion(id, coche, new Date(), motivo);

        listaDevoluciones.add(devolucion);
        System.out.println("Devolución registrada.");
    }

    private static void verDevolucionesHoy() {
        Date hoy = new Date();
        for (int i = 0; i < listaDevoluciones.size(); i++) {
            Devolucion devolucion = listaDevoluciones.get(i);
            if (dateFormat.format(devolucion.getFecha()).equals(dateFormat.format(hoy))) {
                System.out.println(devolucion);
            }
        }
    }

    private static void verDevolucionesFecha() {
        System.out.print("Ingrese la fecha en formato dd/MM/yyyy: ");
        String fechaIngresada = scanner.nextLine();

        for (int i = 0; i < listaDevoluciones.size(); i++) {
            Devolucion devolucion = listaDevoluciones.get(i);
            if (dateFormat.format(devolucion.getFecha()).equals(fechaIngresada)) {
                System.out.println(devolucion);
            }
        }
    }

    private static void eliminarDevolucion() {
        System.out.print("Ingrese el ID de la devolución a eliminar: ");
        String id = scanner.nextLine();

        for (int i = 0; i < listaDevoluciones.size(); i++) {
            Devolucion devolucion = listaDevoluciones.get(i);
            if (devolucion.getId().equals(id)) {
                listaDevoluciones.remove(i);
                System.out.println("Devolución eliminada.");
                return;
            }
        }
        System.out.println("Devolución no encontrada.");
    }

    private static void modificarDevolucion() {
        System.out.print("Ingrese el ID de la devolución a modificar: ");
        String id = scanner.nextLine();

        for (int i = 0; i < listaDevoluciones.size(); i++) {
            Devolucion devolucion = listaDevoluciones.get(i);
            if (devolucion.getId().equals(id)) {
                System.out.print("Nuevo motivo (FIN_ALQUILER, ACCIDENTE, etc.): ");
                Motivo nuevoMotivo = Motivo.valueOf(scanner.nextLine().toUpperCase());

                devolucion.setMotivo(nuevoMotivo);
                System.out.println("Devolución modificada.");
                return;
            }
        }
        System.out.println("Devolución no encontrada.");
    }

    private static void verDevolucionesPorMarca() {
        System.out.print("Ingrese la marca del coche: ");
        String marca = scanner.nextLine();

        for (int i = 0; i < listaDevoluciones.size(); i++) {
            Devolucion devolucion = listaDevoluciones.get(i);
            if (devolucion.getCoche().getMarca().equalsIgnoreCase(marca)) {
                System.out.println(devolucion);
            }
        }
    }

    private static void guardarYSalir() throws IOException {
        FileWriter writer = new FileWriter("devoluciones_coches.txt");
        for (int i = 0; i < listaDevoluciones.size(); i++) {
            writer.write(listaDevoluciones.get(i).toString() + "\n");
        }
        writer.close();
        System.out.println("Datos guardados en devoluciones_coches.txt");
    }
}
