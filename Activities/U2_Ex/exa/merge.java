
public class merge {
    public static <T> void merge(T[] A, T[] B, T[] C){
        if(!A.getClass().equals(B.getClass())){
            throw new IllegalArgumentException("No son del mismo tipo");
        }

        for(Integer i = 0; i< A.length;i++){
            C[i] = A[i];
        }

        for(Integer i= A.length; i < A.length+B.length;i++){
            C[i] = B[i-A.length];
        }

        
    }
    public static void main(String[] args) {
        Integer[] A ={1,2,3};
        Integer [] B = {4,5,6};
        Integer [] C = new Integer[A.length+B.length];

        merge(A, B, C);
        for(int i : C){
            System.out.println(i + "");
        }
    }
}
