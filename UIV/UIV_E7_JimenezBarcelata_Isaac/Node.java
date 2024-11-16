class Node<T> {
    T data;        // Almacena el valor del nodo
    Node<T> next;  // Apunta al siguiente nodo en la cola

    public Node(T data) {
        this.data = data;
        this.next = null; // Inicialmente, no apunta a ningún otro nodo
    }
}
