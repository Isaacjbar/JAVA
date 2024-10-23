import DoublyLinked.DoubleLinkedList;
import Model.Pedido;
import Model.Platillo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    public static void main(String[] args) {
        DoubleLinkedList<Pedido> listaPedidos = new DoubleLinkedList<>();
        ArrayList<Platillo> platillos = new ArrayList<>();
        platillos.add(new Platillo("Lasaña", 250,false));
        platillos.add(new Platillo("Pizza", 200,false));
        platillos.add(new Platillo("Ensalada", 180,true));
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("1. Registrar un nuevo pedido");
            System.out.println("2. Ver todos los pedidos de hoy");
            System.out.println("3. Ver pedidos de una fecha específica");
            System.out.println("4. Eliminar un pedido");
            System.out.println("5. Cambiar detalles de un pedido (actualizar los platillos de un pedido)");
            System.out.println("6. Ver pedidos de un cliente");
            System.out.println("7. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcion) {
                case 1:
                    // Register a new order
                    System.out.println("Número del pedido:");
                    int numero = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.println("Nombre del cliente:");
                    String cliente = scanner.nextLine();
                    System.out.println("Fecha del pedido (yyyy-mm-dd):");
                    Date fecha = Date.valueOf(scanner.nextLine());

                    boolean enough = true;
                    ArrayList<Platillo> tempPla = new ArrayList<>();

                    while (enough) {
                        int i = 0;
                        for (Platillo plat : platillos) {
                            System.out.println("Id: " + "[" + i + "] " + plat.toString());
                            i++;
                        }
                        System.out.println("Platillos disponibles, para escoger digite su id:");
                        tempPla.add(platillos.get(scanner.nextInt()));
                        scanner.nextLine();

                        System.out.println("Pulse '2' para dejar de escoger o cualquier otro número para continuar:");
                        String respuesta = scanner.nextLine();
                        if (respuesta.equals("2")) {
                            enough = false;
                        }
                    }
                    Pedido nuevoPedido = new Pedido(numero, cliente, tempPla, fecha);
                    listaPedidos.add(nuevoPedido);
                    break;
                case 2:
                    Timestamp timeNow = new Timestamp(2024-10-23);

                    break;

                case 3:
                    // View orders by specific date
                    System.out.println("Ingrese la fecha (yyyy-mm-dd):");
                    Date fechaEspecifica = Date.valueOf(scanner.nextLine());
                    listaPedidos.verPedidosPorFecha(fechaEspecifica);
                    break;

                case 4:
                    // Delete an order by order number
                    System.out.println("Número del pedido a eliminar:");
                    int numeroEliminar = scanner.nextInt();
                    listaPedidos.eliminarPedido(numeroEliminar);
                    break;

                case 5:
                    // Update order details
                    System.out.println("Número del pedido a actualizar:");
                    int numeroActualizar = scanner.nextInt();
                    scanner.nextLine();

                    ArrayList<Platillo> nuevosPlatillos = new ArrayList<>();
                    // Code to update the dish list goes here...

                    listaPedidos.actualizarPedido(numeroActualizar, nuevosPlatillos);
                    break;

                case 6:
                    // View orders of a specific customer
                    System.out.println("Ingrese el nombre del cliente:");
                    String clienteBuscar = scanner.nextLine();
                    listaPedidos.verPedidosPorCliente(clienteBuscar);
                    break;

                case 7:
                    // Exit and save orders to file
                    listaPedidos.guardarPedidosEnArchivo();
                    salir = true;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}
