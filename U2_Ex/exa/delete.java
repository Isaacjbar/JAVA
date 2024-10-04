import java.lang.reflect.Array;

public class delete {
    // Funcion delete avanzada (OJO esta viene como delete2)
    @SuppressWarnings("unchecked")
    public static <T> T[] delete(T[] A) {
        Class<?> tipoDato = A.getClass().getComponentType();
        T[] B = (T[]) Array.newInstance(tipoDato, A.length - 1);
        // Copiar todo lo que habia en A en el nuevo B
        for (int i = 0; i < A.length - 1; i++) {
            B[i] = A[i];
        }
        return B;

    }

    // Funcion Delete sencilla (OJO esta viene solo como delite)
    public static <T> void delete(T[] A, int index) {
        A[index] = null;
    }
}
