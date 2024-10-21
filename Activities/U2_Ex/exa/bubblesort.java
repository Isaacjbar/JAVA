
//Ese viene casi completo enfocate en lo de enmedio pero en general si viene casi todo
public class bubblesort {
   
   
   // metodo buble sort
    public static void bubbleSort(int[] arr) {

        int n = arr.length;
        boolean swapped;
        // Iterar sobre todo el arreglo
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            // Comparar elementos adyacentes
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambiar si están en el orden incorrecto
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; // Marcar que hubo un intercambio
                }
            }
            // Si no hubo intercambios, el arreglo ya está ordenado
            if (!swapped) {
                break;
            }
        }
    }
}