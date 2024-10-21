package mx.edu.utez.modelos;
import  mx.edu.utez.enums.TipoCombustible;

public class VehiculoElectrico extends Vehiculo {
    private int nivelBateria;

    public VehiculoElectrico(String marca, String modelo, int año) {
        super(marca, modelo, año, TipoCombustible.ELECTRICO);
        this.nivelBateria = 0; // Batería vacía al inicio
    }

    public void cargarBateria() {
        this.nivelBateria = tipoCombustible.getCapacidadMaxima();
        System.out.println("La batería del vehículo eléctrico ha sido cargada al " + nivelBateria + "%.");
    }

    public int obtenerNivelBateriaActual() {
        return nivelBateria;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Vehículo Eléctrico - Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año);
    }
}