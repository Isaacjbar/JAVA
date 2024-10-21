public class Main {

    // Ejemplo Básico: Contar de 1 a 5 usando recursividad
    public static void contar(int numero) {
        if (numero > 5) {
            return; // Caso base: si el número es mayor que 5, detén la recursión
        }
        System.out.println(numero); // Imprime el número actual
        contar(numero + 1); // Llama a sí misma con el siguiente número
    }

    // Ejemplo Básico: Calcular el factorial de un número usando recursividad
    public static int factorial(int n) {
        if (n == 0) {
            return 1; // Caso base: factorial de 0 es 1
        }
        return n * factorial(n - 1); // Llamada recursiva: n * factorial(n - 1)
    }

    // Ejemplo Intermedio: Calcular el n-ésimo número de Fibonacci usando recursividad
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n; // Casos base: F(0) = 0 y F(1) = 1
        }
        return fibonacci(n - 1) + fibonacci(n - 2); // Llamadas recursivas
    }

    // Ejemplo Avanzado: Búsqueda binaria en un arreglo ordenado usando recursividad
    public static int busquedaBinaria(int[] arr, int izquierda, int derecha, int objetivo) {
        if (izquierda > derecha) {
            return -1; // Caso base: elemento no encontrado
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        if (arr[medio] == objetivo) {
            return medio; // Caso base: elemento encontrado
        }

        if (arr[medio] > objetivo) {
            return busquedaBinaria(arr, izquierda, medio - 1, objetivo); // Buscar en la mitad izquierda
        } else {
            return busquedaBinaria(arr, medio + 1, derecha, objetivo); // Buscar en la mitad derecha
        }
    }

    // Ejemplo Práctico 1: Encontrar el máximo valor en un arreglo usando recursividad
    public static int encontrarMaximo(int[] arr, int index) {
        if (index == arr.length - 1) {
            return arr[index]; // Caso base: solo un elemento, es el máximo
        }
        int maxDelRestante = encontrarMaximo(arr, index + 1); // Buscar en el resto del arreglo
        return Math.max(arr[index], maxDelRestante); // Comparar el elemento actual con el máximo del resto
    }

    // Ejemplo Práctico 2: Resolver el problema de las Torres de Hanoi
    public static void torresDeHanoi(int n, char origen, char destino, char auxiliar) {
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origen + " a " + destino);
            return; // Caso base: mover solo un disco
        }
        torresDeHanoi(n - 1, origen, auxiliar, destino); // Mover n-1 discos de origen a auxiliar
        System.out.println("Mover disco " + n + " de " + origen + " a " + destino); // Mover el disco más grande
        torresDeHanoi(n - 1, auxiliar, destino, origen); // Mover n-1 discos de auxiliar a destino
    }

    public static void main(String[] args) {
        // Ejemplo Básico: Contar de 1 a 5
        System.out.println("Contar de 1 a 5:");
        contar(1);
        System.out.println();

        // Ejemplo Básico: Calcular el factorial de 5
        int resultadoFactorial = factorial(5);
        System.out.println("El factorial de 5 es: " + resultadoFactorial);
        System.out.println();

        // Ejemplo Intermedio: Calcular el número de Fibonacci en la posición 6
        int resultadoFibonacci = fibonacci(6);
        System.out.println("El número de Fibonacci en la posición 6 es: " + resultadoFibonacci);
        System.out.println();

        // Ejemplo Avanzado: Buscar el número 7 en un arreglo
        int[] arreglo = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int resultadoBusqueda = busquedaBinaria(arreglo, 0, arreglo.length - 1, 7);
        System.out.println("El número 7 está en el índice: " + resultadoBusqueda);
        System.out.println();

        // Ejemplo Práctico 1: Encontrar el máximo valor en un arreglo
        int[] arregloMaximo = {3, 1, 4, 1, 5, 9, 2};
        int maximo = encontrarMaximo(arregloMaximo, 0);
        System.out.println("El valor máximo en el arreglo es: " + maximo);
        System.out.println();

        // Ejemplo Práctico 2: Resolver el problema de las Torres de Hanoi
        int numeroDiscos = 3;
        System.out.println("Solución para " + numeroDiscos + " discos:");
        torresDeHanoi(numeroDiscos, 'A', 'C', 'B'); // Mover discos de A a C usando B
    }
}
