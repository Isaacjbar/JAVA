public class Contacto {
    private String nombre;
    private String telefono;

    // Constructor para Contacto
    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método para imprimir el contacto
    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Teléfono: " + telefono;
    }
}
