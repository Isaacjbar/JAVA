package Model;

import java.sql.Date;
import java.util.ArrayList;

public class Pedido {
    private int numero;
    private String cliente;
    private ArrayList<Platillo> platillosPedidos;
    private double total;
    private Date fecha;

    // Constructor
    public Pedido(int numero, String cliente, ArrayList<Platillo> platillosPedidos, Date fecha) {
        this.numero = numero;
        this.cliente = cliente;
        this.platillosPedidos = platillosPedidos;
        this.fecha = fecha;
        this.total = calcularTotal();
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public ArrayList<Platillo> getPlatillosPedidos() {
        return platillosPedidos;
    }

    public double getTotal() {
        return total;
    }

    public Date getFecha() {
        return fecha;
    }

    // toString method
    @Override
    public String toString() {
        return "Pedido{" +
                "numero=" + numero +
                ", cliente='" + cliente + '\'' +
                ", platillosPedidos=" + platillosPedidos +
                ", total=" + total +
                ", fecha=" + fecha +
                '}';
    }

    // Method to calculate the total price of the order
    public double calcularTotal() {
        double suma = 0;
        for (Platillo platillo : platillosPedidos) {
            suma += platillo.getPrecio();
        }
        return suma;
    }
    // Method to set a new list of ordered dishes (platillos)
    public void setPlatillosPedidos(ArrayList<Platillo> nuevosPlatillos) {
        this.platillosPedidos = nuevosPlatillos;
    }

    // Method to update the total
    public void setTotal(double total) {
        this.total = total;
    }
}
