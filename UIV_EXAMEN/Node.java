class Node<T> {
    T data;        // Almacena el dato del nodo (de tipo genérico T).
    Node<T> next;  // Referencia al siguiente nodo en la estructura.

    // Constructor que inicializa el nodo con un dato y la referencia 'next' como null.
    public Node(T data) {
        this.data = data;   // Asigna el valor proporcionado al atributo 'data'.
        this.next = null;   // Inicializa 'next' como null (nodo no enlazado aún).
    }
}
