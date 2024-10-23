import DoublyLinked.DoubleLinkedList;
import Model.Pedido;
import Model.Platillo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
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
                    // Show all orders from today
                    Date today = Date.valueOf(LocalDate.now()); // Use current date
                    boolean foundOrders = false;

                    for (int i = 0; i < listaPedidos.size(); i++) {
                        Pedido temp = listaPedidos.get(i);
                        if (temp.getFecha().equals(today)) {
                            System.out.println(temp.toString());
                            foundOrders = true;
                        }
                    }

                    if (!foundOrders) {
                        System.out.println("No se encontraron pedidos para hoy.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese la fecha (yyyy-mm-dd): ");
                    String fechaInput = scanner.next();
                    Date fecha2 = Date.valueOf(fechaInput);

                    boolean pedidosEncontrados = false;

                    for (int i = 0; i < listaPedidos.size(); i++) {
                        Pedido pedido = listaPedidos.get(i);
                        if (pedido.getFecha().equals(fecha2)) {
                            System.out.println(pedido);
                            pedidosEncontrados = true;
                        }
                    }

                    if (!pedidosEncontrados) {
                        System.out.println("No se encontraron pedidos para la fecha: " + fechaInput);
                    }
                    break;
                case 4:
                    System.out.println("Número del pedido a eliminar:");
                    int numeroEliminar = scanner.nextInt();
                    listaPedidos.remove(numeroEliminar);
                    break;

                case 5:
                    System.out.print("Ingrese el número del pedido a modificar: ");
                    int numeroPedido = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    Pedido pedidoAActualizar = null;

                    for (int i = 0; i < listaPedidos.size(); i++) {
                        Pedido pedido = listaPedidos.get(i);
                        if (pedido.getNumero() == numeroPedido) {
                            pedidoAActualizar = pedido;
                            break;
                        }
                    }

                    if (pedidoAActualizar != null) {
                        ArrayList<Platillo> nuevosPlatillos = new ArrayList<>();
                        String opcionPlatillo;

                        do {
                            System.out.print("Ingrese el nombre del nuevo platillo: ");
                            String nombre = scanner.nextLine();
                            System.out.print("Ingrese el precio del platillo: ");
                            double precio = scanner.nextDouble();
                            System.out.print("¿Es vegano? (true/false): ");
                            boolean vegano = scanner.nextBoolean();
                            scanner.nextLine();

                            nuevosPlatillos.add(new Platillo(nombre, precio, vegano));

                            System.out.print("¿Desea agregar otro platillo? (s/n): ");
                            opcionPlatillo = scanner.nextLine();
                        } while (opcionPlatillo.equalsIgnoreCase("s"));

                        pedidoAActualizar.getPlatillosPedidos().clear();
                        pedidoAActualizar.getPlatillosPedidos().addAll(nuevosPlatillos);
                        pedidoAActualizar.calcularTotal();

                        System.out.println("Platillos del pedido actualizado correctamente.");
                    } else {
                        System.out.println("Pedido no encontrado.");
                    }
                    break;

                case 6:
                    System.out.print("Ingrese el nombre del cliente: ");
                    String clienteD = scanner.next();

                    for (int i = 0; i < listaPedidos.size(); i++) {
                        Pedido pedido = listaPedidos.get(i);
                        if (pedido.getCliente().equalsIgnoreCase(clienteD)) {
                            System.out.println(pedido);
                        }
                    }
                    break;

                case 7:
                    // Exit and save orders to file
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("pedidos.txt"))) {
                        for (int i = 0; i < listaPedidos.size(); i++) {
                            Pedido pedido = listaPedidos.get(i);
                            writer.write("Pedido Número: " + pedido.getNumero());
                            writer.newLine();
                            writer.write("Cliente: " + pedido.getCliente());
                            writer.newLine();
                            writer.write("Fecha: " + pedido.getFecha());
                            writer.newLine();
                            writer.write("Platillos:");
                            writer.newLine();
                            for (Platillo platillo : pedido.getPlatillosPedidos()) {
                                writer.write("  - " + platillo.toString());
                                writer.newLine();
                            }
                            writer.write("Total: " + pedido.getTotal());
                            writer.newLine();
                            writer.write("-----------------------------");
                            writer.newLine();
                        }
                        System.out.println("Pedidos guardados en pedidos.txt.");
                    } catch (IOException e) {
                        System.out.println("Error al guardar pedidos: " + e.getMessage());
                    }
                    salir = true; // exit the loop
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

    }
}
