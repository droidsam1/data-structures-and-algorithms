package linkedlist;

import java.util.List;

public class NaiveLinkedList<T> {

    private Node<T> head;

    public NaiveLinkedList() {
        this.head = null;
    }

    public NaiveLinkedList(List<T> aList) {
        if (aList == null) {
            throw new IllegalArgumentException();
        }

        Node<T> currentNode = null;
        this.head = null;
        for (T element : aList) {
            var nextNode = new Node<>(element);
            if (this.head == null) {
                this.head = nextNode;
            }
            if (currentNode != null) {
                currentNode.next = nextNode;
            }
            currentNode = nextNode;
        }
    }

    public void print() {
        var currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public NaiveLinkedList<T> add(T value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            var node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(value);
        }
        return this;
    }

    public T get(int index) {
        var nodeAtIndex = getNodeAt(index);
        return nodeAtIndex != null ? nodeAtIndex.value : null;

    }

    protected Node<T> getNodeAt(int index) {
        var currentNode = head;
        while (index-- > 0) {
            if (currentNode == null) {
                return null;
            }
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public T getLast() {

        var currentNode = head;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode.value;
    }

    public void reverse() {
        Node<T> currentNode = this.head;
        Node<T> previousNode = null;
        Node<T> nextNode;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        this.head = previousNode;
    }

    protected static class Node<T> {

        private T value;
        private Node<T> next;

        Node(T value) {
            this.value = value;
        }

        protected void removeItSelf() {
            if (next == null) {
                throw new IllegalArgumentException("This method cannot remove the last element of the list");
            }
            this.value = next.value;
            this.next = next.next;

        }

    }
}


