public class Pokemon {
    private String nombre;

    private int vida;
    private int ataque;
    private int defensa;
    private int velocidad;
    
    private Tipo tipo;
    private Movimiento[] movimientos = new Movimiento[2];

    public Pokemon(String nombre, int vida, int ataque, int defensa, int velocidad, Tipo tipo,
            Movimiento[] movimientos) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.tipo = tipo;
        this.movimientos = movimientos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Movimiento[] getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Movimiento[] movimientos) {
        this.movimientos = movimientos;
    }

    //Ataque
    public boolean atacar(Pokemon contrincante, Movimiento movimiento){
        int dado = (int) Math.random() * 100;
        if (dado <= movimiento.getPrecision()) {
            System.out.println(this.nombre + " logro conectar su ataque");
            return true;
        }
        System.out.println(contrincante.getNombre() + " Esquivo el ataque");
        return false;
    }

    //Recibir daño
    public void recibirDanio(Pokemon contrincante, Movimiento movimiento){

        double modificador = 1.0;
        modificador = tipo.calcularVentaja(contrincante.getTipo(), tipo);

        double danioTotal = (movimiento.getPotencia() + contrincante.getAtaque()) - this.defensa;
        if(danioTotal <= 0){
            danioTotal = 1;
        }

        vida -= danioTotal;

        //Tenemos que ver si el pokemon ya quedo en 0
        if (vida <= 0) {
            System.out.println("El pokemon se ha debilitado");
        }
    }    
}
