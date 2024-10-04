public class Advanced {

    /*
        1. Crea un programa que permita al usuario ingresar dos arreglos de números enteros.
        
        2. Fusiona ambos arreglos en uno solo utilizando el método merge.

        3. Permite al usuario eliminar un elemento del arreglo fusionado utilizando ambos 
        métodos de eliminación (hacer nulo el valor en una posición y reducir el tamaño del arreglo).
        
        4. Divide el arreglo fusionado nuevamente en dos subarreglos utilizando el método split.
        
        5. Finalmente, permite al usuario añadir un elemento a uno de los subarreglos 
        utilizando el método que incrementa el tamaño del arreglo.
        
        6. YA Imprime los arreglos en cada paso del proceso (fusión, eliminación, división, y adición).
     */
    public static <T> String toString(T[] A){
        String print = "";
        for (T t : A) {
            print += t + "\n";
        }
        return print;
    }
    //Merge
    public static <T> void merge(T[] A, T[] B, T[]C){
        if(!A.getClass().equals(B.getClass())||!A.getClass().equals(C.getClass())){
            throw new IllegalArgumentException("No son de la misma clase");
        }
        for (int i = 0; i < A.length; i++) {
            C[i]=A[i];
        }
        for (int i = A.length; i < A.length + B.length; i++) {
            C[i]= B[i-A.length];
        }

    }

    public static void main(String[] args) {
        
    }
}
