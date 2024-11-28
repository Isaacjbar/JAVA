public class Queue<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    public boolean offer(T element) {
        Node<T> newNode = new Node<>(element);
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

    public T peek() {
        return (_______ != null) ? front.data : null;
    }

    public T poll() {
        if (_______()) {
            return null;
        }
        T data = _______.data;
        front = front._______;
        if (front == null) {
            rear = _______;
        }
        _______--;
        return data;
    }

    public boolean isEmpty() {
        return _______ == 0;
    }
}
