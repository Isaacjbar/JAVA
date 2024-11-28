import java.util.EmptyStackException;

public class Stack<E> {

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public void push(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public E pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        E data = top.data;
        top = top.next;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}
