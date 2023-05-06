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
            return;
        }

        while (currentNode.left != null || currentNode.right != null) {
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

    public boolean contains(int i) {
        return true;
    }


    private static class Node<T extends Comparable<T>> {

        private final T value;
        private Node<T> left;
        private Node<T> right;


        private Node(T value) {
            this.value = value;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }
    }

}
