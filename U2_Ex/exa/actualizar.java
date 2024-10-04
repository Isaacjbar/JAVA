//Este se considera un actualizar o como un add asi viene en el examen como add
public class actualizar{
    public static <T> void add(T[] arreglo, int index,T element){
        arreglo[index] = element;
    }
    public static void main(String[] args) {
        Integer [] arreglo = {2,5,8};

        add(arreglo,0,199);
        add(arreglo,1,1);
        add(arreglo,2,10);

        for (int i : arreglo){
            System.out.println(i + "");
        }
    }
}