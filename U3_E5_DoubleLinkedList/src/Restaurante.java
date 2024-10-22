import DoublyLinked.ListaPedidos;
import Model.Pedido;
import Model.Platillo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    public static void main(String[] args) {
        ListaPedidos listaPedidos = new ListaPedidos();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("1. Registrar un nuevo pedido");
            System.out.println("2. Ver todos los pedidos de hoy");
            System.out.println("3. Ver pedidos de una fecha específica");
            System.out.println("4. Eliminar un pedido");
            System.out.println("5. Cambiar detalles de un pedido");
            System.out.println("6. Ver pedidos de un cliente");
            System.out.println("7. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (opcion) {
                case 1:
                    // Register a new order
                    System.out.println("Número del pedido:");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Nombre del cliente:");
                    String cliente = scanner.nextLine();
                    System.out.println("Fecha del pedido (yyyy-mm-dd):");
                    Date fecha = Date.valueOf(scanner.nextLine());

                    ArrayList<Platillo> platillos = new ArrayList<>();
                    // Code to add dishes to platillos goes here...

                    Pedido nuevoPedido = new Pedido(numero, cliente, platillos, fecha);
                    listaPedidos.registrarPedido(nuevoPedido);
                    break;

                case 2:
                    // View orders of today
                    listaPedidos.verPedidosHoy(new Date(System.currentTimeMillis()));
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
