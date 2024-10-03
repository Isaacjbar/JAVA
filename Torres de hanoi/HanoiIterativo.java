import java.util.Stack;
 
class HanoiIterativo {
    
    // Método para imprimir el estado de las torres
    static void imprimirTorres(Stack<Integer> torreA, Stack<Integer> torreB, Stack<Integer> torreC) {
        System.out.println("Torre A: " + torreA);
        System.out.println("Torre B: " + torreB);
        System.out.println("Torre C: " + torreC);
        System.out.println("----------------------------------");
    }

    // Método para mover disco entre dos torres
    static void moverDiscoEntreTorres(Stack<Integer> origen, Stack<Integer> destino, char torreOrigen, char torreDestino) {
        if (origen.isEmpty()) {
            origen.push(destino.pop());
            System.out.println("Mueve disco " + origen.peek() + " de " + torreDestino + " a " + torreOrigen);
        } else if (destino.isEmpty()) {
            destino.push(origen.pop());
            System.out.println("Mueve disco " + destino.peek() + " de " + torreOrigen + " a " + torreDestino);
        } else if (origen.peek() > destino.peek()) {
            origen.push(destino.pop());
            System.out.println("Mueve disco " + origen.peek() + " de " + torreDestino + " a " + torreOrigen);
        } else {
            destino.push(origen.pop());
            System.out.println("Mueve disco " + destino.peek() + " de " + torreOrigen + " a " + torreDestino);
        }
    }

    // Método para resolver Torres de Hanoi iterativamente
    static void resolverTorresDeHanoi(int n, Stack<Integer> torreA, Stack<Integer> torreB, Stack<Integer> torreC) {
        char A = 'A', B = 'B', C = 'C';

        // Si el número de discos es par, intercambiar la torre de destino con la torre auxiliar
        if (n % 2 == 0) {
            char temp = C;
            C = B;
            B = temp;
        }

        int numMovimientos = (int) Math.pow(2, n) - 1; // Número total de movimientos

        for (int i = 1; i <= numMovimientos; i++) {
            if (i % 3 == 1) {
                moverDiscoEntreTorres(torreA, torreC, A, C); // Mover entre A y C
            } else if (i % 3 == 2) {
                moverDiscoEntreTorres(torreA, torreB, A, B); // Mover entre A y B
            } else if (i % 3 == 0) {
                moverDiscoEntreTorres(torreB, torreC, B, C); // Mover entre B y C
            }
            imprimirTorres(torreA, torreB, torreC); // Imprimir el estado de las torres después de cada movimiento
        }
    }

    public static void main(String[] args) {
        int n = 3;  // Número de discos

        // Crear las torres como pilas
        Stack<Integer> torreA = new Stack<>();
        Stack<Integer> torreB = new Stack<>();
        Stack<Integer> torreC = new Stack<>();

        // Colocar los discos en la torre A (del más grande al más pequeño)
        for (int i = n; i >= 1; i--) {
            torreA.push(i);
        }

        // Imprimir el estado inicial de las torres
        System.out.println("Estado inicial de las torres:");
        imprimirTorres(torreA, torreB, torreC);

        // Resolver las torres de Hanoi
        resolverTorresDeHanoi(n, torreA, torreB, torreC);

        // Imprimir el estado final de las torres
        System.out.println("Estado final de las torres:");
        imprimirTorres(torreA, torreB, torreC);
    }
}
