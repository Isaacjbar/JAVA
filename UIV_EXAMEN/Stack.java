import java.util.EmptyStackException; // Excepción utilizada si la pila está vacía.

public class Stack<T> { // Clase genérica para implementar una pila.
    private Node<T> top; // Nodo que representa la parte superior de la pila.
    private int size;    // Número de elementos en la pila.

    // Constructor que inicializa la pila como vacía.
    public Stack() {
        top = null;  // No hay nodos, la pila está vacía.
        size = 0;    // El tamaño inicial es 0.
    }

    // Método para insertar un elemento en la pila.
    public void push(T data) {
        Node<T> newNode = new Node<>(data); // Crea un nuevo nodo con el dato proporcionado.
        newNode.next = top;                // El nuevo nodo apunta al nodo que era el 'top'.
        top = newNode;                     // Ahora el nuevo nodo se convierte en el 'top'.
        size++;                            // Incrementa el tamaño de la pila.
    }

    // Método para ver el elemento en la parte superior de la pila sin eliminarlo.
    public T peek() {
        if (size == 0) { // Si la pila está vacía, lanza una excepción.
            throw new IllegalStateException("Lista vacia");
        }
        return top.data; // Retorna el dato del nodo en la cima de la pila.
    }

    // Método para eliminar y devolver el elemento en la parte superior de la pila.
    public T pop() {
        if (top == null) { // Si la pila está vacía, lanza una excepción.
            throw new EmptyStackException();
        }
        T data = top.data; // Guarda el dato del nodo en la cima.
        top = top.next;    // Actualiza el 'top' al siguiente nodo.
        size--;            // Decrementa el tamaño de la pila.
        return data;       // Retorna el dato eliminado.
    }
}
