// Necesitamos importar el paquete java.lang.reflect.Array para manejar arreglos de manera dinámica
import java.lang.reflect.Array;

public class Inter{
 /*
    Nivel Intermedio: División y Combinación de Arreglos
    1. YA Crea un programa que permita al usuario ingresar un arreglo de números enteros de cualquier tamaño.
    
    2. YA Divide el arreglo en dos subarreglos utilizando un índice proporcionado por el usuario. 
    Utiliza el método split.
    
    3. YA Permite al usuario añadir elementos a cada subarreglo, utilizando ambos tipos de adición 
    (cambiar en una posición específica y aumentar el tamaño del arreglo).
    
    4. YA Imprime ambos subarreglos antes y después de las operaciones.
 */    

    public static <T> String toString(T[] A){
        String print = "";
        for(T a : A){
            print += a +"\n";
        }
        return print;
    }
    public static <T> void updateA(T[] A,int ind, T valor){
        A[ind] = valor;
    }
    public static <T> void updateD(T[] A, int ind){
        A[ind] = null;
    }
    @SuppressWarnings("unchecked")
    public static <T> T[] add(T[] A, T valor){
        Class<?> cl = A.getClass().getComponentType();
        T[] B = (T[]) Array.newInstance(cl,(A.length+1));
        for (int i = 0; i < A.length; i++) {
            B[i]=A[i];
        }
        B[B.length-1]=valor;
        return B;
    }
    @SuppressWarnings("unchecked")
    public static <T> T[] delete (T[] A){
        Class<?> cl = A.getClass().getComponentType();
        T[] B = (T[]) Array.newInstance(cl, A.length-1);
        for (int i = 0; i < B.length; i++) {
            B[i]=A[i];
        }
        return B;
    }
    //Método Split
    public static <T> void split(T[] A, T[] B, T[] C, int index){
        //Verificar tipos de clases
        if(!A.getClass().equals(B.getClass())||!A.getClass().equals(C.getClass())){
            throw new IllegalArgumentException("Las clase no son del mismo tipo");
        }

        if(index < 0|| index >= A.length){
            throw new IllegalArgumentException("Fuera de rango");
        }
        //1
        for (int i = 0; i < index; i++) {
            B[i] = A[i];
        }
        //2
        for (int i = index; i < A.length; i++) {
            C[i-index] = A[i];
        }


    }
    
    public static void main(String[] args){
        Integer[] nu = {1,2,3,4};
        Integer[] nd = new Integer[2];
        Integer[] nt = new Integer[2];

        split(nu,nd,nt,2);
        System.out.println(toString(nu));
        System.out.println(toString(nd));
        System.out.println(toString(nt));
    }
}

