package modelos;

import enums.TipoCombustible;

public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int año;
    protected TipoCombustible tipoCombustible;

    public Vehiculo(String marca, String modelo, int año, TipoCombustible tipoCombustible) {
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.tipoCombustible = tipoCombustible;
    }

    public abstract void mostrarDetalles();
}
