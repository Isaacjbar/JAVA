public enum Size{
    SMALL(500,"carton"),MEDIUM(800,"carton"),LARGE(1000,"plastico"),XLARGE(1200,"plastico");

    private final int capacidad;
    private final String material;

    private Size(int ml,String material){
        this.capacidad=ml;
        this.material=material;
    }
    public int getCapacidad(){
        return this.capacidad;
    }

    public String getMaterial(){
        return this.material;
    }
}
