package mx.edu.utez;

import java.util.ArrayList;

public class ReservaControlador {
    private Reserva reserva;
    private ArrayList<Reserva> reservas = new ArrayList<>();

    public ReservaControlador(Reserva reserva) {
        this.reserva = reserva;
    }

    public ReservaControlador(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public ReservaControlador() {
    }

    // Registrar una nueva reserva.
    public void registrarReserva(){

    }
    // Modificar una reserva existente.
    public void modificarReserva(){

    }
    // Cancelar una reserva.
    public void cancelarReserva(){

    }
    // Consultar una reserva por nombre o por fecha.
    public Reserva consultarReservaCliente(){
        return reserva;
    }
    // Consultar una reserva por fecha.
    public Reserva consultarReservaFecha(){
        return null;
    }
    // Listar todas las reservas activas.
    public ArrayList<Reserva> cosultarReservas(){
        return null;
    }
}
