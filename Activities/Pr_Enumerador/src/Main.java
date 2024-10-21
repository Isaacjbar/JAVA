public class Main {
    private String nombreProducto;
    private double precio;
    //Es una caracteristica, no un tipo de dato.
    private Size size;

    public Main(String nombre,double precio,Size size){
        this.nombreProducto=nombre;
        this.precio=precio;
        this.size=size;

    }
    public static void main(String[] args) {
        Main refresco1 = new Main("Coca",60,Size.SMALL);


        System.out.println(refresco1.size.getCapacidad());
    }
}