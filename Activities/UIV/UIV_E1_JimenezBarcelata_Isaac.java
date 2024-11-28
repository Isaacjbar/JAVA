import java.util.Scanner;
import java.util.Stack;

public class UIV_E1_JimenezBarcelata_Isaac {
    public static void main(String[] args) {
        //Recibir cadena
        Scanner sc = new Scanner(System.in);
        System.out.println("Give a sentence");
        String cadena = sc.nextLine();

        //Caracteres de cadena a una pila 
        Stack<Character> pila = new Stack<Character>();
        char[] arreglo = cadena.toCharArray();
        
        for (char c : arreglo) {
            //Volteando la lista 
            pila.push(c);
        }

        System.out.println("La pila");
        System.out.println(pila);
        
        String respuesta = "";

        for (int i = 0; i < arreglo.length; i++) {
            respuesta = respuesta + pila.pop();
        }

        //Ahora vamos a devolver la respuesta
        System.out.println("Tu cadena al reves");
        System.out.println(respuesta);
        
        System.out.println("La pila");
        System.out.println(pila);
    }

}
