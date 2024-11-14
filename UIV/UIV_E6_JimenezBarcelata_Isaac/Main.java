public class Main {
    
    public static void main(String[] args) {
        System.out.println("¡Bienvenido al juego de Pokémon RPG!");

        // Crear los Pokémon de cada jugador
        Pokemon chikorita = new Pokemon("Chikorita", 120, 20, 20, 25, Tipo.PLANTA, new Movimiento[] {Movimiento.LATIGO_CEPA, Movimiento.DRENADORAS});
        Pokemon vaporeon = new Pokemon("Vaporeon", 300, 40, 50, 35, Tipo.AGUA, new Movimiento[] {Movimiento.CASCADA, Movimiento.HIDRO_CANON});
        Pokemon fenekin = new Pokemon("Fenekin", 120, 25, 15, 28, Tipo.FUEGO, new Movimiento[] {Movimiento.ASCUAS, Movimiento.GIRO_FUEGO});
        Pokemon greninja = new Pokemon("Greninja", 350, 50, 35, 60, Tipo.AGUA, new Movimiento[] {Movimiento.SURF, Movimiento.HIDRO_CANON});
        Pokemon arcanine = new Pokemon("Arcanine", 250, 45, 35, 40, Tipo.FUEGO, new Movimiento[] {Movimiento.LANZA_LLAMAS, Movimiento.ONDA_IGNEA});
        Pokemon sprigatito = new Pokemon("Sprigatito", 120, 27, 20, 30, Tipo.PLANTA, new Movimiento[] {Movimiento.RAYO_SOLAR, Movimiento.HOJAS_NAVAJA});

        // Crear los jugadores y asignar sus equipos de Pokémon
        Jugador ximena = new Jugador("Ximena", new Pokemon[] {vaporeon, sprigatito, arcanine});
        Jugador erick = new Jugador("Erick", new Pokemon[] {greninja, fenekin, chikorita});

        // Crear la batalla entre los dos jugadores
        Batalla pelea = new Batalla(ximena, erick);

        // Iniciar la batalla
        pelea.inciar();
    }
}
