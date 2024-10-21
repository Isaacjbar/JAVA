package jbar;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaDeCompras {
    private ArrayList<String> listaCompras;

    public ListaDeCompras() {
        listaCompras = new ArrayList<>();
    }

    // 1. Agregar elementos
    public void agregarElemento(String item) {
        listaCompras.add(item);
        System.out.println(item + " ha sido agregado a la lista.");
    }

    // 2. Verificar si un artículo está en la lista
    public boolean verificarElemento(String item) {
        return listaCompras.contains(item);
    }

    // 3. Obtener un elemento específico
    public String obtenerElemento(int index) {
        if (index >= 0 && index < listaCompras.size()) {
            return listaCompras.get(index);
        } else {
            return "Índice fuera de rango";
        }
    }

    // 4. Eliminar artículos
    public void eliminarElemento(String item) {
        if (listaCompras.remove(item)) {
            System.out.println(item + " ha sido eliminado de la lista.");
        } else {
            System.out.println(item + " no está en la lista.");
        }
    }

    // 5. Imprimir la lista
    public void imprimirLista() {
        if (listaCompras.isEmpty()) {
            System.out.println("La lista de compras está vacía.");
        } else {
            System.out.println("Lista de compras:");
            for (String item : listaCompras) {
                System.out.println(item);
            }
        }
    }

    // 6. Limpiar la lista
    public void limpiarLista() {
        listaCompras.clear();
        System.out.println("La lista ha sido limpiada.");
    }

    public static void main(String[] args) {
        ListaDeCompras lista = new ListaDeCompras();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar artículo");
            System.out.println("2. Verificar si artículo está en la lista");
            System.out.println("3. Obtener un artículo por índice");
            System.out.println("4. Eliminar artículo");
            System.out.println("5. Imprimir lista");
            System.out.println("6. Limpiar lista");
            System.out.println("7. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre del artículo: ");
                    String item = scanner.nextLine();
                    lista.agregarElemento(item);
                    break;
                case 2:
                    System.out.print("Introduce el nombre del artículo a verificar: ");
                    String itemVerificar = scanner.nextLine();
                    if (lista.verificarElemento(itemVerificar)) {
                        System.out.println(itemVerificar + " está en la lista.");
                    } else {
                        System.out.println(itemVerificar + " no está en la lista.");
                    }
                    break;
                case 3:
                    System.out.print("Introduce el índice del artículo: ");
                    int indice = scanner.nextInt();
                    System.out.println("Artículo en el índice " + indice + ": " + lista.obtenerElemento(indice));
                    break;
                case 4:
                    System.out.print("Introduce el nombre del artículo a eliminar: ");
                    String itemEliminar = scanner.nextLine();
                    lista.eliminarElemento(itemEliminar);
                    break;
                case 5:
                    lista.imprimirLista();
                    break;
                case 6:
                    lista.limpiarLista();
                    break;
                case 7:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    }
}