public class Jugador {
    private String nombre;
    private Queue<Pokemon> equipo;

    public Jugador(String nombre, Pokemon[] equipoInicial) {
        this.nombre = nombre;
        this.equipo = new Queue<>();
        for (Pokemon pokemon : equipoInicial) {
            this.equipo.offer(pokemon);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Pokemon obtenerPokemon() {
        return equipo.peek(); // El primer Pokémon es el que está actualmente en batalla
    }

    public void pokemonDebilitado() {
        equipo.poll(); // Elimina al Pokémon debilitado y permite que el siguiente entre en batalla
    }

    public boolean tienePokemonDisponible() {
        return !equipo.isEmpty();
    }

    @Override
    public String toString() {
        return nombre + " con equipo: " + equipo.toString();
    }
}
