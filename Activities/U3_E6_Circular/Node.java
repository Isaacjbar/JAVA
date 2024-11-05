public class Node<T>{

    //Estos son los atributos que definen la LinkedList
    public T data;
    public Node<T> next;

    //Constructor del nodo
    public Node(T data){
        this.data = data;
        this.next = null;
    }

    //getter del dato
    public T getData(){
        return this.data;
    }
}