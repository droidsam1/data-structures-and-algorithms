package heap;

public class BasicMaxHeap<T> {


    private final Node<T> root;

    public BasicMaxHeap(T[] input) {
        this.root = new Node<>(input[0], null, null);
    }

    public T getTopElement() {
        return root.value;
    }

    private record Node<T>(T value, Node<T> left, Node<T> right) {

    }
}


