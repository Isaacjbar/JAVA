package jbar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Comparation_List {

    public static void main(String[] args) {
        int cantidadElementos = 100_000;
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        Random random = new Random();

        // Llenar ambas listas con 100,000 números enteros aleatorios
        for (int i = 0; i < cantidadElementos; i++) {
            int numeroAleatorio = random.nextInt();
            arrayList.add(numeroAleatorio);
            linkedList.add(numeroAleatorio);
        }

        // Medir tiempo de acceso a 100 elementos aleatorios
        medirTiempoAcceso(arrayList, "ArrayList");
        medirTiempoAcceso(linkedList, "LinkedList");

        // Medir tiempo de inserción de 100 elementos en posiciones aleatorias
        medirTiempoInsercion(arrayList, "ArrayList");
        medirTiempoInsercion(linkedList, "LinkedList");

        // Medir tiempo de eliminación de 100 elementos en posiciones aleatorias
        medirTiempoEliminacion(arrayList, "ArrayList");
        medirTiempoEliminacion(linkedList, "LinkedList");
    }

    public static void medirTiempoAcceso(List<Integer> lista, String tipoLista) {
        Random random = new Random();
        long tiempoInicio = System.nanoTime();

        // Realizar 100 accesos a elementos aleatorios
        for (int i = 0; i < 100; i++) {
            lista.get(random.nextInt(lista.size()));
        }

        long tiempoFin = System.nanoTime();
        System.out.println(tipoLista + " - Tiempo de acceso: " + (tiempoFin - tiempoInicio) / 1_000_000.0 + " ms");
    }

    public static void medirTiempoInsercion(List<Integer> lista, String tipoLista) {
        Random random = new Random();
        long tiempoInicio = System.nanoTime();

        // Insertar 100 elementos en posiciones aleatorias
        for (int i = 0; i < 100; i++) {
            lista.add(random.nextInt(lista.size()), random.nextInt());
        }

        long tiempoFin = System.nanoTime();
        System.out.println(tipoLista + " - Tiempo de inserción: " + (tiempoFin - tiempoInicio) / 1_000_000.0 + " ms");
    }

    public static void medirTiempoEliminacion(List<Integer> lista, String tipoLista) {
        Random random = new Random();
        long tiempoInicio = System.nanoTime();

        // Eliminar 100 elementos en posiciones aleatorias
        for (int i = 0; i < 100; i++) {
            lista.remove(random.nextInt(lista.size()));
        }

        long tiempoFin = System.nanoTime();
        System.out.println(tipoLista + " - Tiempo de eliminación: " + (tiempoFin - tiempoInicio) / 1_000_000.0 + " ms");
    }
}