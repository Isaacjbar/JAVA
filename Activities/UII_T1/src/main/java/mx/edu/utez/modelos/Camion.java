package mx.edu.utez.modelos;
import  mx.edu.utez.enums.TipoCombustible;
import mx.edu.utez.interfaces.Motor;

public class Camion extends Vehiculo implements Motor {
    private int nivelCombustible;

    public Camion(String marca, String modelo, int año, TipoCombustible tipoCombustible) {
        super(marca, modelo, año, tipoCombustible);
        this.nivelCombustible = 0; // Tanque vacío al inicio
    }

    @Override
    public void llenarTanque() {
        this.nivelCombustible = tipoCombustible.getCapacidadMaxima();
        System.out.println("El tanque del camión ha sido llenado a " + nivelCombustible + " litros.");
    }

    @Override
    public int obtenerNivelCombustibleActual() {
        return nivelCombustible;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Camión - Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año);
    }
}