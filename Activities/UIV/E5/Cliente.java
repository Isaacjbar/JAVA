package E5;
public class Cliente { 
    
    private String nombre;
    private Queue<Producto> carrito;
    private int tiempo;

    public Cliente(String nombre, Queue<Producto> carrito) {
        this.nombre = nombre;
        this.carrito = carrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Queue<Producto> getCarrito() {
        return carrito;
    }

    public void setCarrito(Queue<Producto> carrito) {
        this.carrito = carrito;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }
}