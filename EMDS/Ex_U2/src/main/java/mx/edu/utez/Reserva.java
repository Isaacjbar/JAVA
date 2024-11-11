package mx.edu.utez;

import java.sql.Date;

/*
    Propiedades
    Nombre del cliente
    Número de personas
    Fecha y hora de la reserva
    Mesa asignada
*/

public class Reserva {
    private Integer idReserva;
    private String nombreCliente;
    private Integer numeroPersonas;
    private Date fechaReserva;
    private Integer mesa;

    public Reserva(Integer idReserva, String nombreCliente, Integer numeroPersonas, Date fechaReserva, Integer mesa) {
        this.idReserva = idReserva;
        this.nombreCliente = nombreCliente;
        this.numeroPersonas = numeroPersonas;
        this.fechaReserva = fechaReserva;
        this.mesa = mesa;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Integer getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(Integer numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }
}
