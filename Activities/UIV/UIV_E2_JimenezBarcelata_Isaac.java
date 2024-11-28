import java.util.Stack;

public class UIV_E2_JimenezBarcelata_Isaac {

    // Método para evaluar la expresión en notación polaca inversa
    public static int evaluateRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            // Verificar si el token es un operador
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                // Extraer los dos últimos elementos de la pila
                int b = stack.pop();
                int a = stack.pop();

                // Realizar la operación correspondiente y apilar el resultado
                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                        break;
                }
            } else {
                // Si el token es un número, convertirlo a entero y apilarlo
                stack.push(Integer.parseInt(token));
            }
        }

        // El resultado final de la expresión es el único elemento en la pila
        return stack.pop();
    }

    
    public static void main(String[] args) {
        // Declaración de los arreglos de prueba
        String[] E1 = {"2", "1", "+", "3", "*"};
        String[] E2 = {"4", "13", "5", "/", "+"};
        String[] E3 = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        // Evaluación y muestra de resultados
        System.out.println("E1: " + String.join(" ", E1) + " = " + evaluateRPN(E1)); // Esperado: 9
        System.out.println("E2: " + String.join(" ", E2) + " = " + evaluateRPN(E2)); // Esperado: 6
        System.out.println("E3: " + String.join(" ", E3) + " = " + evaluateRPN(E3)); // Esperado: 22
    }
}
