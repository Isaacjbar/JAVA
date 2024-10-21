import java.util.ArrayList;

public class AgendaContactos {
    // Lista de contactos utilizando ArrayList
    private ArrayList<Contacto> contactos;

    // Constructor para inicializar la lista
    public AgendaContactos() {
        contactos = new ArrayList<>();
    }

    // Método para agregar un contacto
    public void agregarContacto(Contacto contacto) {
        contactos.add(contacto);
        System.out.println("Contacto agregado exitosamente.");
    }

    // Método para mostrar todos los contactos
    public void mostrarContactos() {
        if (contactos.isEmpty()) {
            System.out.println("No hay contactos disponibles.");
        } else {
            System.out.println("Lista de Contactos:");
            for (int i = 0; i < contactos.size(); i++) {
                System.out.println((i + 1) + ". " + contactos.get(i));
            }
        }
    }

    // Método para buscar un contacto por índice
    public Contacto buscarContactoPorIndice(int indice) {
        if (indice >= 0 && indice < contactos.size()) {
            return contactos.get(indice);
        } else {
            System.out.println("Índice fuera de rango.");
            return null;
        }
    }

    // Método para modificar el teléfono de un contacto
    public void modificarTelefono(int indice, String nuevoTelefono) {
        Contacto contacto = buscarContactoPorIndice(indice);
        if (contacto != null) {
            contacto.setTelefono(nuevoTelefono);
            System.out.println("Número de teléfono modificado correctamente.");
        }
    }

    // Método para eliminar un contacto por índice
    public void eliminarContacto(int indice) {
        if (indice >= 0 && indice < contactos.size()) {
            contactos.remove(indice);
            System.out.println("Contacto eliminado exitosamente.");
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

    // Método para mostrar el número total de contactos
    public int totalContactos() {
        return contactos.size();
    }
}
