public class Coche {
    private String marca;
    private String modelo;
    private String serie;
    private Color color;

    // Constructor
    public Coche(String marca, String modelo, String serie, Color color) {
        this.marca = marca;
        this.modelo = modelo;
        this.serie = serie;
        this.color = color;
    }

    // Getters
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getSerie() {
        return serie;
    }

    public Color getColor() {
        return color;
    }

    // toString
    @Override
    public String toString() {
        return "Coche{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", serie='" + serie + '\'' +
                ", color=" + color +
                '}';
    }
}
