// Necesitamos importar el paquete java.lang.reflect.Array para manejar arreglos de manera dinámica
import java.lang.reflect.Array;
 
public class Arreglos {

    // Crear Método para imprimir contenidos de un arreglo
    public static <T> String toString(T[] A) {
        // Puede ser que A sea de números, String, objeto, etc.
        String impresion = "";
        for (T elemento : A) {
            impresion += elemento + "\n"; // Se concatenan los elementos con un salto de línea
        }
        return impresion;
    }

    // Método 1 para añadir: cambiar el valor en una posición específica del arreglo
    public static <T> void add(T[] A, int index, T element) {
        // Se reemplaza el valor en la posición 'index' con el nuevo elemento
        A[index] = element;
    }

    // Método 2 para añadir: incrementar el tamaño del arreglo agregando un nuevo elemento
    @SuppressWarnings("unchecked")
    public static <T> T[] add2(T[] A, T element) {
        // Obtener el tipo de dato del arreglo A
        Class<?> tipoDato = A.getClass().getComponentType();
        // Crear un nuevo arreglo B con una longitud mayor en 1 que A
        T[] B = (T[]) Array.newInstance(tipoDato, A.length + 1);
        // Copiar los elementos de A a B
        for (int i = 0; i < A.length; i++) {
            B[i] = A[i];
        }
        // Agregar el nuevo elemento en la última posición
        B[B.length - 1] = element;
        return B; // Retornar el nuevo arreglo
    }

    // Método 1 para eliminar: hacer nulo el valor en una posición específica
    public static <T> void delete(T[] A, int index) {
        // Se hace nulo el valor en la posición 'index'
        A[index] = null;
    }

    // Método 2 para eliminar: reducir el tamaño del arreglo eliminando el último elemento
    @SuppressWarnings("unchecked")
    public static <T> T[] delete2(T[] A) {
        // Obtener el tipo de dato del arreglo A
        Class<?> tipoDato = A.getClass().getComponentType();
        // Crear un nuevo arreglo B con una longitud menor en 1 que A
        T[] B = (T[]) Array.newInstance(tipoDato, A.length - 1);
        // Copiar los elementos de A a B, excepto el último
        for (int i = 0; i < B.length; i++) {
            B[i] = A[i];
        }
        return B; // Retornar el nuevo arreglo
    }

    // Método para dividir (split) un arreglo A en dos arreglos B y C a partir de un índice dado
    public static <T> void split(T[] A, int index, T[] B, T[] C) {
        // Verificar que los arreglos sean del mismo tipo
        if (!A.getClass().equals(B.getClass()) || !A.getClass().equals(C.getClass())) {
            throw new IllegalArgumentException("Los arreglos no son del mismo tipo");
        }
        // Verificar que el índice sea válido
        if (index < 0 || index > A.length) {
            throw new IllegalArgumentException("El índice no es válido");
        }
        // Copiar la primera parte de A en B
        for (int i = 0; i < index; i++) {
            B[i] = A[i];
        }
        // Copiar la segunda parte de A en C
        for (int i = index; i < A.length; i++) {
            C[i - index] = A[i];
        }
    }

    // Método para fusionar (merge) dos arreglos A y B en un arreglo C
    public static <T> void merge(T[] A, T[] B, T[] C) {
        // Verificar que los arreglos A y B sean del mismo tipo
        if (!A.getClass().equals(B.getClass())) {
            throw new IllegalArgumentException("Los arreglos no son del mismo tipo");
        }
        // Copiar los elementos de A en C
        for (int i = 0; i < A.length; i++) {
            C[i] = A[i];
        }
        // Copiar los elementos de B en C
        for (int i = A.length; i < A.length + B.length; i++) {
            C[i] = B[i - A.length];
        }
    }

    public static void main(String[] args) {
        // Crear dos arreglos de enteros
        Integer[] A = { 10, 20, 30, 40 };
        Integer[] B = { 50, 60, 70 };

        // Crear un arreglo C con espacio suficiente para fusionar A y B
        Integer[] C = new Integer[A.length + B.length];

        // Fusionar A y B en C
        merge(A, B, C);

        // Imprimir los elementos de C
        for (Integer n : C) {
            System.out.print(n + ", ");
        }

        System.out.println("\n------------");

        // Crear dos nuevos arreglos D y E para dividir A
        Integer[] D = new Integer[2];
        Integer[] E = new Integer[2];

        // Dividir A en D y E a partir del índice 2
        split(A, 2, D, E);

        // Imprimir los elementos de D
        for (Integer n : D) {
            System.out.print(n + ", ");
        }

        System.out.println("\n------------");

        // Agregar elementos a D utilizando add2
        D = add2(D, 999);
        D = add2(D, 2024);

        // Imprimir los elementos de D
        for (Integer n : D) {
            System.out.print(n + ", ");
        }

        System.out.println("\n------------");

        // Eliminar un elemento de D en la posición 1
        delete(D, 1);

        // Imprimir los elementos de D (con un valor nulo en la posición eliminada)
        for (Object n : D) {
            System.out.print(n + " ");
        }

        System.out.println("\n------------");

        // Reducir el tamaño de D eliminando el último elemento
        D = delete2(D);

        // Imprimir los elementos de D (ahora sin el último valor)
        for (Object n : D) {
            System.out.print(n + " ");
        }
    }
}
