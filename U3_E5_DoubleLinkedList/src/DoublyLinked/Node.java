package DoublyLinked;
import Model.Pedido;

class Node {
    Pedido data;
    Node prev;
    Node next;

    public Node(Pedido data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
