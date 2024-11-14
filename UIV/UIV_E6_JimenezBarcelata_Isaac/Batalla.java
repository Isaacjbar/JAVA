import java.util.Scanner;

public class Batalla {
    private Jugador jugador1;
    private Jugador jugador2;
    private Scanner scanner;

    public Batalla(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.scanner = new Scanner(System.in);
    }

    public void inciar() {
        System.out.println("¡Comienza la batalla entre " + jugador1.getNombre() + " y " + jugador2.getNombre() + "!");
        
        while (jugador1.tienePokemonDisponible() && jugador2.tienePokemonDisponible()) {
            Pokemon poke1 = jugador1.obtenerPokemon();
            Pokemon poke2 = jugador2.obtenerPokemon();
            
            if (poke1.getVelocidad() >= poke2.getVelocidad()) {
                turno(poke1, poke2, jugador1, jugador2);
            } else {
                turno(poke2, poke1, jugador2, jugador1);
            }

            verificarDebilitado(jugador1, jugador2);
            verificarDebilitado(jugador2, jugador1);
        }
        
        if (jugador1.tienePokemonDisponible()) {
            System.out.println("¡" + jugador1.getNombre() + " ha ganado la batalla!");
        } else {
            System.out.println("¡" + jugador2.getNombre() + " ha ganado la batalla!");
        }
    }

    private void turno(Pokemon atacante, Pokemon defensor, Jugador atacanteJugador, Jugador defensorJugador) {
        System.out.println(atacanteJugador.getNombre() + ", elige un movimiento para " + atacante.getNombre());
        for (int i = 0; i < atacante.getMovimientos().length; i++) {
            System.out.println((i + 1) + ". " + atacante.getMovimientos()[i]);
        }
        int eleccion = scanner.nextInt() - 1;

        Movimiento movimientoSeleccionado = atacante.getMovimientos()[eleccion];
        if (atacante.atacar(defensor, movimientoSeleccionado)) {
            defensor.recibirDanio(atacante, movimientoSeleccionado);
        }
    }

    private void verificarDebilitado(Jugador jugadorAtacante, Jugador jugadorDefensor) {
        if (jugadorDefensor.obtenerPokemon().getVida() <= 0) {
            System.out.println(jugadorDefensor.obtenerPokemon().getNombre() + " de " + jugadorDefensor.getNombre() + " se ha debilitado.");
            jugadorDefensor.pokemonDebilitado();
        }
    }
}
