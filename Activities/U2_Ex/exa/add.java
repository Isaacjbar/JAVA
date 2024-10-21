//En el examen este viene como el add2
public class add {
    @SuppressWarnings("unchked")
    public static <T> T[] add(T[] A, T element){
        Class<?> tipoDato = A.getClass().getComponentType();
        T[] B = (T[]) java.lang.reflect.Array.newInstance(tipoDato, A.length+1);
        for(int i = 0; i<A.length;i++){
            B[i]=A[i];
        }
        B[B.length-1]=element;
        return B;
    }
    public static void main(String[] args) {
        Integer[] A ={1,2,3};

        A=add(A, 360);
        for (Integer i : A){
            System.out.println(i+"");
        }
    }
}
