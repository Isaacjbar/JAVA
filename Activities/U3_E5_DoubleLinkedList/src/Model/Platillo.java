package Model;

public class Platillo {
    private String nombre;
    private double precio;
    private boolean vegano;

    // Constructor
    public Platillo(String nombre, double precio, boolean vegano) {
        this.nombre = nombre;
        this.precio = precio;
        this.vegano = vegano;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isVegano() {
        return vegano;
    }

    // toString method
    @Override
    public String toString() {
        return "Platillo{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", vegano=" + vegano +
                '}';
    }
}
