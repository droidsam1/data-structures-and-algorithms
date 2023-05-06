package tree;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> head;

    public BinarySearchTree(T[] inputArray) {
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

    public void preorderTraversalPrint() {
        var currentNode = head;
        if (currentNode == null) {
            return;
        }
        preorderTraversalPrint(currentNode);
    }

    public void preorderTraversalPrint(Node<T> currentNode) {
        if (currentNode == null) {
            return;
        }
        System.out.printf("%s ", currentNode.value);
        preorderTraversalPrint(currentNode.left);
        preorderTraversalPrint(currentNode.right);
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
