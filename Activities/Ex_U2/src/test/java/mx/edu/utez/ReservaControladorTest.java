package mx.edu.utez;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReservaControladorTest {

    ReservaControlador reservaControlador;
    Date fecha;
    Reserva reserva;
    ArrayList<Reserva> reservas = new ArrayList<>();
    String nombreTest;
    Reserva temp;

    @BeforeEach
    void setUp() {
        fecha = new Date(System.currentTimeMillis());
        reserva = new Reserva(1,"Isaac",4,fecha,1);
        temp = new Reserva(2,"Helen",2,fecha,2);
        reservaControlador = new ReservaControlador();
        reservas.add(reserva);
        nombreTest = "";
    }

    // Nombre: Registrar una reserva
    // Id: CPR01
    @Test
    void registrarReserva() {
        reservas.add(reserva);
        assertEquals(reservas.get(1),reserva);
    }
    // Nombre: Modificar una reserva
    // Id: CPM01
    @Test
    void modificarReserva() {
        temp.setNombreCliente("Helen");
        reservas.set(1,reserva);
        assertEquals(reservas.get(1),reserva);
    }

    // Nombre: Consultar una reserva por cliente
    // Id: CPC01
    @Disabled
    @Test
    void consultarReservaCliente() {
        nombreTest = "Isaac";
        for (int i = 0; i < reservas.size() ; i++) {
            temp = reservas.get(i);
            if(temp.getNombreCliente().equals(nombreTest)){
                return temp;
            }
        }
        assertEquals();
    }

    // Nombre: Consultar una reserva por fecha
    // Id: CPC02
    @Disabled
    @Test
    void consultarReservaFecha() {
    }

    // Nombre: Consultar reservas
    // Id: CPC03
    @Disabled
    @Test
    void cosultarReservas() {
    }
    // Nombre: Cancelar una reserva
    // Id: CPCA01
    @Test
    void cancelarReserva() {
        reservas.remove(0);
    }
}