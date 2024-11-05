import java.sql.Date;

public class Prestamo {
    private int id;
    private String usuario;
    private ArrayList<Libro> libros; // Usamos la ArrayList personalizada
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private EstadoPrestamo estado;

    public Prestamo(int id, String usuario, ArrayList<Libro> libros, Date fechaPrestamo, EstadoPrestamo estado) {
        this.id = id;
        this.usuario = usuario;
        this.libros = libros;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = new Date(fechaPrestamo.getTime() + (7 * 24 * 60 * 60 * 1000)); // +1 semana
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        StringBuilder librosPrestados = new StringBuilder();
        for (int i = 0; i < libros.size(); i++) {
            librosPrestados.append(libros.get(i).getTitulo());
            if (i < libros.size() - 1) {
                librosPrestados.append(", ");
            }
        }
        return "ID Préstamo: " + id + ", Usuario: " + usuario + ", Libros: " + librosPrestados.toString()
                + ", Fecha Préstamo: " + fechaPrestamo + ", Fecha Devolución: " + fechaDevolucion + ", Estado: " + estado;
    }
}
