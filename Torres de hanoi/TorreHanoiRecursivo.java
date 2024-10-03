public class TorreHanoiRecursivo {
 
    // Método recursivo para mover los discos
    public static void moverDiscos(int n, char origen, char destino, char auxiliar, int[] torreOrigen, int[] torreDestino, int[] torreAuxiliar) {
        if (n == 1) {
            moverDisco(torreOrigen, torreDestino, origen, destino);
            return;
        }
        // Mover n-1 discos de origen a auxiliar
        moverDiscos(n - 1, origen, auxiliar, destino, torreOrigen, torreAuxiliar, torreDestino);

        // Mover el disco n de origen a destino
        moverDisco(torreOrigen, torreDestino, origen, destino);

        // Mover los n-1 discos de auxiliar a destino
        moverDiscos(n - 1, auxiliar, destino, origen, torreAuxiliar, torreDestino, torreOrigen);
    }

    // Método auxiliar para mover un disco de una torre a otra
    public static void moverDisco(int[] torreOrigen, int[] torreDestino, char origen, char destino) {
        int disco = 0;
        // Encontrar el disco en la torre origen
        for (int i = torreOrigen.length - 1; i >= 0; i--) {
            if (torreOrigen[i] != 0) {
                disco = torreOrigen[i];
                torreOrigen[i] = 0;
                break;
            }
        }
        // Colocar el disco en la torre destino
        for (int i = 0; i < torreDestino.length; i++) {
            if (torreDestino[i] == 0) {
                torreDestino[i] = disco;
                break;
            }
        }
        System.out.println("Mover disco " + disco + " de " + origen + " a " + destino);
    }

    // Método para mostrar el estado de las torres
    public static void mostrarTorres(int[] torreA, int[] torreB, int[] torreC) {
        System.out.println("Torre A: " + imprimirTorre(torreA));
        System.out.println("Torre B: " + imprimirTorre(torreB));
        System.out.println("Torre C: " + imprimirTorre(torreC));
    }

    // Método para convertir una torre en cadena
    public static String imprimirTorre(int[] torre) {
        StringBuilder sb = new StringBuilder();
        for (int disco : torre) {
            if (disco != 0) {
                sb.append(disco).append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int numDiscos = 3; // Cambia el número de discos si lo deseas
        int[] torreA = new int[numDiscos];
        int[] torreB = new int[numDiscos];
        int[] torreC = new int[numDiscos];

        // Inicializamos la torre A con los discos
        for (int i = 0; i < numDiscos; i++) {
            torreA[i] = numDiscos - i;
        }

        // Mostrar estado inicial
        System.out.println("Estado inicial:");
        mostrarTorres(torreA, torreB, torreC);

        // Resolver la Torre de Hanói
        moverDiscos(numDiscos, 'A', 'C', 'B', torreA, torreC, torreB);

        // Mostrar estado final
        System.out.println("\nEstado final:");
        mostrarTorres(torreA, torreB, torreC);
    }
}
