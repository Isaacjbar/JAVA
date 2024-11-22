public class Queue<T> { // Clase genérica para implementar una cola.
    private Node<T> front; // Primer elemento de la cola (cabeza).
    private Node<T> rear;  // Último elemento de la cola (cola).
    private int size;      // Número de elementos en la cola.

    // Constructor que inicializa la cola como vacía.
    public Queue() {
        this.front = null; // No hay nodos en la cabeza de la cola.
        this.rear = null;  // No hay nodos en la cola.
        this.size = 0;     // Tamaño inicial es 0.
    }

    // Método para agregar un elemento al final de la cola.
    public boolean offer(T element) {
        Node<T> newNode = new Node<>(element); // Crea un nuevo nodo con el dato proporcionado.
        if (rear != null) {                   // Si la cola no está vacía:
            rear.next = newNode;              // El nodo actual al final apunta al nuevo nodo.
        }
        rear = newNode;                       // Ahora el nuevo nodo es el 'rear'.
        if (front == null) {                 // Si la cola estaba vacía, el nuevo nodo es también el 'front'.
            front = rear;
        }
        size++;                              // Incrementa el tamaño de la cola.
        return true;                         // Retorna true para indicar éxito.
    }

    // Método para obtener el primer elemento de la cola sin eliminarlo.
    public T peek() {
        return (front != null) ? front.data : null; // Retorna el dato del nodo 'front', o null si está vacía.
    }

    // Método para eliminar y devolver el primer elemento de la cola.
    public T poll() {
        if (isEmpty()) { // Si la cola está vacía, retorna null.
            return null;
        }
        T data = front.data; // Guarda el dato del nodo 'front'.
        front = front.next;  // Avanza al siguiente nodo.
        if (front == null) { // Si ahora está vacía, también actualiza 'rear' a null.
            rear = null;
        }
        size--;              // Decrementa el tamaño de la cola.
        return data;         // Retorna el dato eliminado.
    }

    // Método para verificar si la cola está vacía.
    public boolean isEmpty() {
        return size == 0; // Retorna true si el tamaño es 0.
    }
}
