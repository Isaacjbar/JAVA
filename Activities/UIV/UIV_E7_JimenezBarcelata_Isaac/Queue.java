public class Queue<T> {

    private Node<T> front;  // Primer elemento (cabeza de la cola)
    private Node<T> rear;   // Último elemento (final de la cola)
    private int size;       // Tamaño de la cola

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Añade un elemento al final de la cola
    public boolean offer(T element) {
        Node<T> newNode = new Node<>(element);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) { // Si la cola estaba vacía
            front = rear;
        }
        size++;
        return true;
    }

    public T poll() {
        if (isEmpty()) {
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front == null) { // Si la cola queda vacía
            rear = null;
        }
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
