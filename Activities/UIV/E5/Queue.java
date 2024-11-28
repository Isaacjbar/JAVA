package E5;
public class Queue<E> { 

    private static class Node<E> {
        public E data;
        public Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    } 

    private Node<E> front; // el frente
    private Node<E> rear;  // el final
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    // Método para agregar un elemento a la cola
    public boolean offer(E data) {
        Node<E> newNode = new Node<>(data);

        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;
        if (front == null) {
            front = rear;
        }
        size++;
        return true;
    }

    // Método para ver el elemento al frente sin removerlo
    public E peek() {
        return (front != null) ? front.data : null;
    }

    // Método para verificar si la cola está vacía
    public boolean isEmpty() {
        return size == 0; // También podría ser return front == null;
    }

    // Método para remover y retornar el elemento al frente de la cola
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        E data = front.data;
        front = front.next;
        if (front == null) { // La cola se quedó vacía
            rear = null;
        }
        size--;
        return data;
    }

    // Método para obtener el tamaño de la cola
    public int size() {
        return this.size;
    }
}
