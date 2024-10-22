package DoublyLinked;

import Model.Pedido;
import Model.Platillo;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;

public class ListaPedidos {
    private Node head;
    private Node tail;

    public ListaPedidos() {
        this.head = null;
        this.tail = null;
    }

    // Register a new order
    public void registrarPedido(Pedido nuevoPedido) {
        Node newNode = new Node(nuevoPedido);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // View all orders placed today
    public void verPedidosHoy(Date hoy) {
        Node current = head;
        while (current != null) {
            if (current.data.getFecha().equals(hoy)) {
                System.out.println(current.data);
            }
            current = current.next;
        }
    }

    // View orders placed on a specific date
    public void verPedidosPorFecha(Date fecha) {
        Node current = head;
        while (current != null) {
            if (current.data.getFecha().equals(fecha)) {
                System.out.println(current.data);
            }
            current = current.next;
        }
    }

    // Delete an order by order number
    public void eliminarPedido(int numero) {
        Node current = head;
        while (current != null) {
            if (current.data.getNumero() == numero) {
                if (current == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Pedido eliminado: " + numero);
                return;
            }
            current = current.next;
        }
        System.out.println("Pedido no encontrado.");
    }

    // Update order details (change the dishes)
    public void actualizarPedido(int numero, ArrayList<Platillo> nuevosPlatillos) {
        Node current = head;
        while (current != null) {
            if (current.data.getNumero() == numero) {
                current.data.setPlatillosPedidos(nuevosPlatillos);
                current.data.setTotal(current.data.calcularTotal());
                System.out.println("Pedido actualizado: " + numero);
                return;
            }
            current = current.next;
        }
        System.out.println("Pedido no encontrado.");
    }

    // View all orders from a specific customer
    public void verPedidosPorCliente(String cliente) {
        Node current = head;
        while (current != null) {
            if (current.data.getCliente().equals(cliente)) {
                System.out.println(current.data);
            }
            current = current.next;
        }
    }

    // Save orders to a text file before exiting
    public void guardarPedidosEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pedidos.txt", true))) {
            Node current = head;
            while (current != null) {
                writer.write(current.data.toString());
                writer.newLine();
                current = current.next;
            }
            System.out.println("Pedidos guardados en el archivo pedidos.txt.");
        } catch (IOException e) {
            System.out.println("Error al guardar los pedidos: " + e.getMessage());
        }
    }
}
