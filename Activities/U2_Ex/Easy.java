// Necesitamos importar el paquete java.lang.reflect.Array para manejar arreglos de manera dinámica
import java.lang.reflect.Array;

public class Easy {
    /*
     1. Nivel Básico: Manejo de Arreglos y Operaciones Básicas
    -YA Crea un programa que permita al usuario ingresar un arreglo de 5 números enteros.

    -YA Permite al usuario cambiar el valor de un elemento en una posición específica utilizando 
      el método que reemplaza el valor en el índice indicado.

    -YA Permite al usuario añadir un nuevo elemento al arreglo utilizando el método que incrementa 
      el tamaño del arreglo.

    -YA Realiza una eliminación de un elemento en una posición específica (haciendo nulo el valor) 
      y luego reduce el tamaño del arreglo eliminando el último elemento.

    -YA Imprime el arreglo después de cada operación.
     */
    public static <T> String toString(T[] A){
        String impresion="";
        for(T e : A){
            impresion += e + "\n";
        }
        return impresion;
    }

    //Update o add basico
    public static <T> void addU (T[] A, int ind, T valor){
        A[ind] = valor;
    }
    //Add Dinamico
    @SuppressWarnings("unchecked")
    public static <T> T[] add (T[] A,T valor){
        Class<?> tipodeClase = A.getClass().getComponentType();
        T[] B = (T[]) Array.newInstance(tipodeClase, (A.length+1) );
        
        for (int i = 0; i < A.length; i++) {
            B[i]= A[i];
        }
        B[B.length-1] = valor;

        return B;
    }
    //Delete basico, como update
    public static <T> void deleteU (T[] A, int ind){
        A[ind] = null;
    }
    //Delete dinamico
    public static <T> T[] delete(T[] A){
        Class<?> tiCl = A.getClass().getComponentType();
        T[] B = (T[]) Array.newInstance(tiCl, (A.length-1));
        for (int i = 0; i < B.length; i++) {
            B[i] = A[i];
        }
        return B;
    }

    public static void main(String[] args) {
        String[] nu = new String[5];
        
        addU(nu, 0, "1");
        System.out.println(toString(nu));
        
        System.out.println("\n________________________");
        
        nu = add(nu, "2");
        System.out.println(toString(nu));
        
        System.out.println("\n________________________");
        
        deleteU(nu, 5);
        System.out.println(toString(nu));
        
        System.out.println("\n________________________");
        
        nu = delete(nu);
        System.out.println(toString(nu));
    }
}
