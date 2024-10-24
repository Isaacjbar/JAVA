import java.util.Date;

public class Devolucion {
    private String id;
    private Coche coche;
    private Date fecha;
    private Motivo motivo;

    // Constructor
    public Devolucion(String id, Coche coche, Date fecha, Motivo motivo) {
        this.id = id;
        this.coche = coche;
        this.fecha = fecha;
        this.motivo = motivo;
    }

    // Getters
    public String getId() {
        return id;
    }

    public Coche getCoche() {
        return coche;
    }

    public Date getFecha() {
        return fecha;
    }

    public Motivo getMotivo() {
        return motivo;
    }
    public void setMotivo(Motivo motivo){
        this.motivo=motivo;
    }

    // toString
    @Override
    public String toString() {
        return "Devolucion{" +
                "id='" + id + '\'' +
                ", coche=" + coche +
                ", fecha=" + fecha +
                ", motivo=" + motivo +
                '}';
    }
}
