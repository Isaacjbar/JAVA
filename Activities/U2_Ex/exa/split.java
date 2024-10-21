//Si viene tambien estudialo para completar como cuadros en blanco del codigo
public class split {
    
    public static <T> void split(T[] A,int index, T[] B, T[] C){
        if(!A.getClass().equals(B.getClass()) || !A.getClass().equals(C.getClass())){
            throw new IllegalArgumentException ("Los arreglos no son del mismo tipo");

        
        }
        if (index < 0 || index >= A.length){
            throw new IllegalArgumentException("Esta fuera del rango");
            
        }

        for (int i=0; i<index; i ++){
            B[i]=A[i];
        }

        for(int i=index;i< A.length;i++){
            C[i-index]=A[i];
        }
    }

    //Principalmente de aqui para arriba
    public static void main(String[] args) {
        Integer[] A = {1,2,3,4,5,6,7,8,9,10};
        Integer[] B = new Integer[5];
        Integer[] C = new Integer[5];

        split(A, 5, B, C);

        for(int i : B){
            System.out.println(i + "");
        }
        System.out.println("\n--------------------------------------------");
        for(int i : C){
            System.out.println(i + "");
        }
    }

}
