package modelos;

import interfaces.Motor;
import enums.TipoCombustible;

public class Auto extends Vehiculo implements Motor {
    private int nivelCombustible;

    public Auto(String marca, String modelo, int año, TipoCombustible tipoCombustible) {
        super(marca, modelo, año, tipoCombustible);
        this.nivelCombustible = 0; // Tanque vacío al inicio
    }

    @Override
    public void llenarTanque() {
        this.nivelCombustible = tipoCombustible.getCapacidadMaxima();
        System.out.println("El tanque del auto ha sido llenado a " + nivelCombustible + " litros.");
    }

    @Override
    public int obtenerNivelCombustibleActual() {
        return nivelCombustible;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Auto - Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año);
    }
}
