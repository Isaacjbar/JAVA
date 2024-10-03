import java.lang.reflect.Array;

public class ArrayUtils {
    // Método para imprimir los contenidos de un arreglo

    public static <T> String toString(T[] A){
        //Puede ser que A sea de numeros, String, objeto, etc.
        String impresion = "";
        for (T elemento : A) {
            impresion += elemento + "\n";
        }
        return impresion;
    }
    /**
     * Este metodo sirve para agregar un elemento de tipo T
     * en un arreglo generico tambien del tipo T y ya.

     * @param <T>, es un generico
     * @param A, es un arreglo
     * @param index,es donde vamos a agregar un elemento
     * @param element, es lo que vamos a agregar
     */
        
    public static <T> void add(T[]A,int index,T element){
        A[index]=element;
    }
    @SuppressWarnings("unchecked")
    public static <T> T[] add2(T[]A, T element){
        Class<?> tipoDato =A.getClass().getComponentType();
        T[] B=(T[])Array.newInstance(tipoDato,A.length +1);
        for(int i=0; i<A.length;i++){
            B[i]=A[i];
        }
        B[B.length-1]= element;
        return B;
    }

    public static <T> void delete(T[]A,int index){
        A[index]=null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] delete2(T[]A){

        Class<?> tipoDato =A.getClass().getComponentType();

        T[] B=(T[])Array.newInstance(tipoDato,A.length -1);

        for(int i=0; i<B.length;i++){
            B[i]=A[i];
        }
        return B;
    }



    public static <T> void split(T[] A,int index, T[] B, T[] C){
        // Checar las clases de arreglos
        if (!A.getClass().equals(B.getClass())  || !A.getClass().equals(C.getClass())) {
            throw new IllegalArgumentException("Los arreglos no son del mismo tipo");
        }
        // Checar que nuestro indice sea valido
        if (index < 0 || index > A.length) {
            throw new IllegalArgumentException("El indice no es valido");
        }
        //Copiar lo de A en B
        for(int i = 0; i < index; i++){
            B[i] = A[i];
        }
        //Copiar lo de A en C
        for(int i = index; i < A.length; i ++){
            C[i - index] = A[i];
        }
    }

    // Todas las operaciones de arreglos
    public static <T> void merge(T[] A, T[] B, T[] C) {
        // Controlar que los arreglos sean del mismo tipo
        if (!A.getClass().equals(B.getClass())) {
            throw new IllegalArgumentException("Los arreglos no son igual");
        }
        // Copia de los elementos de A en C
        for(int i = 0; i < A.length; i++){
            C[i] = A[i];
        }
        // Copia de los elementos de B en C
        for(int i = A.length; i < A.length + B.length; i++){
            C[i] = B[i - A.length];
        }
    }
// No usar nunca System.arraycopy en tareas ni examenes ya que no lo contara como valida
    public static void main(String[] args) {
        Integer[] A = {20, 29, 35, 200};
        Integer[] B = {17, 31, 82};
        Integer[] C = new Integer[A.length + B.length];

        merge(A, B, C);

        for (Integer n : C) {
            System.out.print(n + ", ");
        }

        // Diagonal invertida = |Alt gr o Alt + Ctrl|
        System.out.println("\n------------");

        Integer[] D = new Integer[1];
        Integer[] E = new Integer[3];

        split(A, 1, D, E);

        for(Integer n : D){
            System.out.print(n + ", ");
        }
        System.out.println("\n--------------");
        D= add2(D,999);
        D= add2(D, 2024);

        for(int n : D){
            System.out.print(n + ",");
        }
        System.out.println("\n--------------");
        delete(D,2);
        for(Object n : D){
            System.out.print(n + " ");
        }
        D = delete2(D);
        System.out.println("\n--------------");
        for(Object n : D){
            System.out.print(n + " ");
        }
    }
}