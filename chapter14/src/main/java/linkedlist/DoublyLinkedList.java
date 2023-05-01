package linkedlist;

import java.util.List;

public class DoublyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public DoublyLinkedList(List<T> aList) {
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
                nextNode.previous = currentNode;
            }
            currentNode = nextNode;
            this.tail = nextNode;
        }
    }


    public DoublyLinkedList<T> append(T element) {
        if (head == null) {
            this.head = new Node<>(element);
            this.tail = this.head;
        } else {
            var currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            var newNode = new Node<>(element);
            newNode.previous = currentNode;
            currentNode.next = newNode;
            this.tail = newNode;
        }
        return this;
    }

    public DoublyLinkedList<T> push(T element) {
        var newNode = new Node<>(element);
        newNode.next = this.head;

        if (this.head != null) {
            this.head.previous = newNode;
        }
        return this;
    }

    public void printReverse() {
        var currentNode = tail;
        while (currentNode != null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.previous;
        }
    }

    private static class Node<T> {

        private final T value;
        private Node<T> next;
        private Node<T> previous;

        Node(T value) {
            this.value = value;
        }

    }

}
