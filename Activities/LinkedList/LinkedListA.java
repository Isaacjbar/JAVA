public class LinkedListA<E> {
    // Atributos de la lista
    private Node<E> head; // Primer nodo de la lista
    private int size;  // Tamaño de la lista

    // Constructor
    public LinkedListA() {
        head = null;
        size = 0;
    }

    // Método para añadir un elemento al final de la lista
    public boolean add(E element) {
        Node<E> newNode = new Node<>(element);

        if (head == null) { // Si la lista está vacía
            head = newNode;
        } else {
            Node<E> current = head;
            // Recorrer hasta el final de la lista
            while (current.next != null) {
                current = current.next;
            }
            // Insertar el nuevo nodo al final
            current.next = newNode;
        }

        size++;
        return true;
    }

    // Método para obtener un elemento por índice
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "El índice está fuera de los límites de la lista"
            );
        }

        Node<E> current = head;
        // Recorrer hasta el índice deseado
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }

    // Método para remover un elemento por índice
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                "El índice está fuera de los límites de la lista"
            );
        }

        if (index == 0) {
            head = head.next; // Remover el primer nodo
        } else {
            Node<E> current = head;
            // Buscar el nodo anterior al que queremos eliminar
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            // Saltar el nodo a eliminar
            current.next = current.next.next;
        }

        size--;
        return true;
    }

    // Método para obtener el tamaño de la lista
    public int size() {
        return size;
    }
}