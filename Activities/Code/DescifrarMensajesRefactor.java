public class DescifrarMensajesRefactor {

    private static final char[] ALFABETO = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ".toCharArray();

    public static void main(String[] args) {
        // Matriz clave A
        double[][] clave = {
            {6, 7, -2},
            {0, 10, 3},
            {0, 0, 8}
        };

        // Mensajes cifrados
        int[][][] mensajesCifrados = {
            {
                {119, -3, 160, 289, 61, -1},
                {131, 52, 85, 199, 92, 131},
                {216, 112, 120, 24, 112, 216}
            },
            {
                {96, 305, 122, 140},
                {152, 257, 161, 281},
                {32, 72, 216, 216}
            },
            {
                {119, -3, 199, 192, 113, 201, 228, 129},
                {131, 52, 129, 225, 131, 264, 147, 107},
                {216, 112, 104, 120, 216, 144, 72, 152}
            },
            {
                {-11, 223, 53, 219},
                {64, 327, 73, 351},
                {144, 152, 8, 216}
            }
        };

        // Calcular la inversa de la clave
        double[][] inversaClave = calcularInversa(clave);

        // Procesar y descifrar cada mensaje
        for (int i = 0; i < mensajesCifrados.length; i++) {
            String mensajeDescifrado = descifrarMensaje(mensajesCifrados[i], inversaClave);
            System.out.println("Mensaje descifrado " + (i + 1) + ": " + mensajeDescifrado);
        }
    }

    // Método principal para descifrar un mensaje
    private static String descifrarMensaje(int[][] mensajeCifrado, double[][] inversaClave) {
        double[][] matrizDescifrada = multiplicarMatrices(inversaClave, mensajeCifrado);
        return convertirMatrizATexto(matrizDescifrada);
    }

    // Calcular la inversa de una matriz 3x3
    private static double[][] calcularInversa(double[][] matriz) {
        double determinante = matriz[0][0] * (matriz[1][1] * matriz[2][2] - matriz[1][2] * matriz[2][1])
                            - matriz[0][1] * (matriz[1][0] * matriz[2][2] - matriz[1][2] * matriz[2][0])
                            + matriz[0][2] * (matriz[1][0] * matriz[2][1] - matriz[1][1] * matriz[2][0]);

        double[][] adjunta = new double[3][3];
        adjunta[0][0] = matriz[1][1] * matriz[2][2] - matriz[1][2] * matriz[2][1];
        adjunta[0][1] = matriz[0][2] * matriz[2][1] - matriz[0][1] * matriz[2][2];
        adjunta[0][2] = matriz[0][1] * matriz[1][2] - matriz[0][2] * matriz[1][1];
        adjunta[1][0] = matriz[1][2] * matriz[2][0] - matriz[1][0] * matriz[2][2];
        adjunta[1][1] = matriz[0][0] * matriz[2][2] - matriz[0][2] * matriz[2][0];
        adjunta[1][2] = matriz[0][2] * matriz[1][0] - matriz[0][0] * matriz[1][2];
        adjunta[2][0] = matriz[1][0] * matriz[2][1] - matriz[1][1] * matriz[2][0];
        adjunta[2][1] = matriz[0][1] * matriz[2][0] - matriz[0][0] * matriz[2][1];
        adjunta[2][2] = matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];

        double[][] inversa = new double[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                inversa[i][j] = adjunta[i][j] / determinante;
            }
        }
        return inversa;
    }

    // Multiplicar dos matrices
    private static double[][] multiplicarMatrices(double[][] a, int[][] b) {
        int filas = a.length;
        int columnas = b[0].length;
        double[][] resultado = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    resultado[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return resultado;
    }

    // Convertir una matriz numérica en texto utilizando el alfabeto
    private static String convertirMatrizATexto(double[][] matriz) {
        StringBuilder mensaje = new StringBuilder();
        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                int num = (int) Math.round(matriz[i][j]);
                if (num >= 1 && num <= ALFABETO.length) {
                    mensaje.append(ALFABETO[num - 1]);
                } else {
                    mensaje.append("["); // Para valores fuera del rango
                }
            }
        }
        return mensaje.toString();
    }
}
