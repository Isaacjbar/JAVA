import java.util.Scanner;

public class Batalla {
    private Jugador jugador1;
    private Jugador jugador2;
    private Queue<Pokemon> turnoCola; // Cola de turnos de ataque
    private Scanner scanner;

    public Batalla(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.turnoCola = new Queue<>(); // Inicializa la cola de turnos
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("¡Comienza la batalla entre " + jugador1.getNombre() + " y " + jugador2.getNombre() + "!");

        // Agrega a los Pokémon en la cola según su velocidad
        agregarPokemonALaCola(jugador1);
        agregarPokemonALaCola(jugador2);

        // Ejecutar la batalla mientras ambos jugadores tengan Pokémon disponibles
        while (jugador1.tienePokemonDisponible() && jugador2.tienePokemonDisponible()) {
            Pokemon atacante = turnoCola.poll(); // Obtener el atacante del turno
            if (atacante == null) break; // Si no hay más Pokémon en la cola, terminar

            Jugador jugadorAtacante = determinarJugadorAtacante(atacante);
            Jugador jugadorDefensor = (jugadorAtacante == jugador1) ? jugador2 : jugador1;
            Pokemon defensor = jugadorDefensor.obtenerPokemon();

            turno(atacante, defensor, jugadorAtacante, jugadorDefensor); // Ejecuta el turno

            // Verificar si el defensor fue debilitado
            if (defensor.getVida() <= 0) {
                System.out.println(defensor.getNombre() + " de " + jugadorDefensor.getNombre() + " se ha debilitado.");
                jugadorDefensor.pokemonDebilitado();
                if (!jugadorDefensor.tienePokemonDisponible()) break; // Si el defensor ya no tiene Pokémon, termina
            }

            // Volver a añadir el atacante a la cola si aún tiene vida y el jugador tiene Pokémon disponibles
            if (atacante.getVida() > 0 && jugadorAtacante.tienePokemonDisponible()) {
                turnoCola.add(atacante);
            }
        }

        // Determinar el ganador
        if (jugador1.tienePokemonDisponible()) {
            System.out.println("¡" + jugador1.getNombre() + " ha ganado la batalla!");
        } else {
            System.out.println("¡" + jugador2.getNombre() + " ha ganado la batalla!");
        }
    }

    private Jugador determinarJugadorAtacante(Pokemon atacante) {
        // Verifica si el atacante pertenece al equipo del jugador 1 o del jugador 2
        if (jugador1.obtenerPokemon() == atacante) {
            return jugador1;
        } else {
            return jugador2;
        }
    }

    private void agregarPokemonALaCola(Jugador jugador) {
        if (jugador.tienePokemonDisponible()) {
            turnoCola.add(jugador.obtenerPokemon());
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
}
