public class Refresco {
    private String nombre;
    private Size size;
    private String sabor;
    private double precio;

    public Refresco(String nombre,String sabor,double precio,Size size){
        this.nombre=nombre;
        this.sabor=sabor;
        this.precio=precio;
        this.size=size;

    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){
        return this.nombre;
    }

    @Override
    public String toString(){
        return "Este es un refresco de: "+ this.sabor +
        " además es de tamaño: " + this.size +
        " el cual contiene: " + this.size.getCapacidad() +
        " ml y esta servido de un vaso de: " + this.size.getMaterial();
    }

    public static void main(String[] args) {
        Refresco refresco1 = new Refresco("Coca Cola", "Piña",60, Size.SMALL);
        Refresco refresco2 = new Refresco("Jarrito", "Tutifruti",80, Size.LARGE);

        System.out.println(refresco1);
        System.out.println("\n----------------");
        System.out.println(refresco2);
    }
}