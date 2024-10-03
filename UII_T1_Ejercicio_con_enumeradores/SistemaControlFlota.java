import modelos.Camion;
import modelos.Auto;
import modelos.VehiculoElectrico;
import enums.TipoCombustible;

public class SistemaControlFlota {
    public static void main(String[] args) {
        // Crear instancias de diferentes vehículos
        Camion camion = new Camion("Mercedes", "Actros", 2020, TipoCombustible.DIESEL);
        Auto auto = new Auto("Toyota", "Corolla", 2018, TipoCombustible.GASOLINA);
        VehiculoElectrico vehiculoElectrico = new VehiculoElectrico("Tesla", "Model S", 2021);

        // Mostrar detalles de cada vehículo
        camion.mostrarDetalles();
        auto.mostrarDetalles();
        vehiculoElectrico.mostrarDetalles();

        // Simular llenado de tanque o carga de batería
        camion.llenarTanque();
        auto.llenarTanque();
        vehiculoElectrico.cargarBateria();

        // Mostrar niveles de combustible o batería
        System.out.println("Nivel de combustible del camión: " + camion.obtenerNivelCombustibleActual() + " litros.");
        System.out.println("Nivel de combustible del auto: " + auto.obtenerNivelCombustibleActual() + " litros.");
        System.out.println("Nivel de batería del vehículo eléctrico: " + vehiculoElectrico.obtenerNivelBateriaActual() + "%.");
    }
}
