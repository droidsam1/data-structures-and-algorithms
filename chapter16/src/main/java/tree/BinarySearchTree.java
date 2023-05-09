package tree;

import java.io.PrintStream;

public class BinarySearchTree<T extends Comparable<T>> {

    private final PrintStream logger;
    private Node<T> head;

    public BinarySearchTree(T[] inputArray) {
        this(inputArray, System.out);
    }

    public BinarySearchTree(T[] inputArray, PrintStream logger) {
        this.logger = logger;
        for (T value : inputArray) {
            add(new Node<>(value));
        }
    }

    private void add(Node<T> node) {
        var currentNode = head;
        if (currentNode == null) {
            head = node;
        }

        while (currentNode != null) {
            if (node.value.compareTo(currentNode.value) > 0) {
                if (currentNode.right == null) {
                    currentNode.right = node;
                    return;
                }
                currentNode = currentNode.right;
            } else {
                if (currentNode.left == null) {
                    currentNode.left = node;
                    return;
                }
                currentNode = currentNode.left;
            }
        }
    }

    public boolean contains(T value) {
        var currentNode = head;
        if (currentNode == null) {
            return false;
        }
        while (currentNode != null) {
            if (value.compareTo(currentNode.value) == 0) {
                return true;
            }
            if (value.compareTo(currentNode.value) > 0) {
                currentNode = currentNode.right;
            } else {
                currentNode = currentNode.left;
            }
        }
        return false;
    }

    public T getGreatestValue() {
        var currentNode = head;
        if (currentNode == null) {
            return null;
        }

        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }

        return currentNode.value;

    }

    public void preOrderTraversalPrint() {
        var currentNode = head;
        if (currentNode == null) {
            return;
        }
        preOrderTraversalPrint(currentNode);
    }

    private void preOrderTraversalPrint(Node<T> currentNode) {
        if (currentNode == null) {
            return;
        }
        print(currentNode);
        preOrderTraversalPrint(currentNode.left);
        preOrderTraversalPrint(currentNode.right);
    }

    public void inOrderTraversalPrint() {
        var currentNode = head;
        if (currentNode == null) {
            return;
        }
        inOrderTraversalPrint(currentNode);
    }

    private void inOrderTraversalPrint(Node<T> currentNode) {
        if (currentNode == null) {
            return;
        }
        inOrderTraversalPrint(currentNode.left);
        print(currentNode);
        inOrderTraversalPrint(currentNode.right);
    }

    public void postOrderTraversalPrint() {
        var currentNode = head;
        if (currentNode == null) {
            return;
        }
        postOrderTraversalPrint(currentNode);
    }

    private void postOrderTraversalPrint(Node<T> currentNode) {
        if (currentNode == null) {
            return;
        }
        postOrderTraversalPrint(currentNode.left);
        postOrderTraversalPrint(currentNode.right);
        print(currentNode);
    }

    private void print(Node<T> currentNode) {
        logger.printf("%s ", currentNode.value);
    }

    private static class Node<T extends Comparable<T>> {

        private final T value;
        private Node<T> left;
        private Node<T> right;

        private Node(T value) {
            this.value = value;
        }
    }

}
