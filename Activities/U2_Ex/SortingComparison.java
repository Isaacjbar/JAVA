import java.util.Random;

public class SortingComparison {

    public static void main(String[] args) {
        // Definición de los arreglos
        int[] arreglo1 = new Random(12345).ints(100, 0, 1000).toArray();
        int[] arreglo2 = new Random(12345).ints(10000, 0, 10000).toArray();
        int[] arreglo3 = new Random(12345).ints(1000000, 0, 1000000).toArray();

        // Prueba con Bubble Sort
        System.out.println("Bubble Sort:");
        medirTiempoEjecucion(arreglo1.clone(), "Bubble Sort");
        medirTiempoEjecucion(arreglo2.clone(), "Bubble Sort");
        medirTiempoEjecucion(arreglo3.clone(), "Bubble Sort");

        // Prueba con Quick Sort
        System.out.println("\nQuick Sort:");
        medirTiempoEjecucion(arreglo1.clone(), "Quick Sort");
        medirTiempoEjecucion(arreglo2.clone(), "Quick Sort");
        medirTiempoEjecucion(arreglo3.clone(), "Quick Sort");

        // Prueba con Insertion Sort
        System.out.println("\nInsertion Sort:");
        medirTiempoEjecucion(arreglo1.clone(), "Insertion Sort");
        medirTiempoEjecucion(arreglo2.clone(), "Insertion Sort");
        medirTiempoEjecucion(arreglo3.clone(), "Insertion Sort");

        // Prueba con Selection Sort
        System.out.println("\nSelection Sort:");
        medirTiempoEjecucion(arreglo1.clone(), "Selection Sort");
        medirTiempoEjecucion(arreglo2.clone(), "Selection Sort");
        medirTiempoEjecucion(arreglo3.clone(), "Selection Sort");

        // Prueba con Merge Sort
        System.out.println("\nMerge Sort:");
        medirTiempoEjecucion(arreglo1.clone(), "Merge Sort");
        medirTiempoEjecucion(arreglo2.clone(), "Merge Sort");
        medirTiempoEjecucion(arreglo3.clone(), "Merge Sort");
    }

    // Función para medir el tiempo de ejecución de un algoritmo de ordenamiento
    public static void medirTiempoEjecucion(int[] arr, String algoritmo) {
        long startTime = System.nanoTime();

        switch (algoritmo) {
            case "Bubble Sort":
                bubbleSort(arr);
                break;
            case "Quick Sort":
                quickSort(arr, 0, arr.length - 1);
                break;
            case "Insertion Sort":
                insertionSort(arr);
                break;
            case "Selection Sort":
                selectionSort(arr);
                break;
            case "Merge Sort":
                mergeSort(arr, 0, arr.length - 1);
                break;
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000; // tiempo en milisegundos
        System.out.println(algoritmo + " tardó: " + duration + " ms");
    }

    // Implementación de Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Implementación de Quick Sort
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    // Implementación de Insertion Sort
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // Implementación de Selection Sort
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // Implementación de Merge Sort
    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private static void merge(int[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = arr[m + 1 + i];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
