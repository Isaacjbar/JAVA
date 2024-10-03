package mx.edu.utez.enums;

public enum TipoCombustible {
    GASOLINA(50),
    DIESEL(70),
    ELECTRICO(100), // Representa la batería en porcentaje
    HIBRIDO(60);

    private final int capacidadMaxima;

    TipoCombustible(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
}
