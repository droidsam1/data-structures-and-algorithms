package heap;

import java.util.ArrayList;
import java.util.List;

public class BasicMaxHeap<T extends Comparable<? super T>> {


    private final List<T> data;

    public BasicMaxHeap(T[] input) {
        this.data = new ArrayList<>();
        this.data.add(input[0]);
        for (int i = 1; i < input.length; i++) {
            this.data.add(input[i]);
            if (input[i].compareTo(this.data.get(0)) > 0) {
                trickleUpNodeAt(i);
            }
        }

    }

    private void trickleUpNodeAt(int elementIndex) {
        var currentElement = data.get(elementIndex);
        var parentIndex = getParentOf(elementIndex);

        while (true) {
            var parent = data.get(parentIndex);
            if (currentElement.compareTo(parent) > 0) {
                data.set(elementIndex, parent);
                data.set(parentIndex, currentElement);
                parentIndex = getParentOf(parentIndex);
            } else {
                break;
            }
        }

    }

    private int getParentOf(int elementIndex) {
        return Math.max(elementIndex / 2 - 1, 0);
    }


    public T getTopElement() {
        return data.get(0);
    }

    public T pop() {
        var topElement = data.get(0);
        trickleDown();
        return topElement;
    }

    private void trickleDown() {
        var lastChildIndex = data.size() - 1;
        var lastChild = data.get(lastChildIndex);
        var parent = 0;
        data.set(parent, lastChild);
        data.remove(lastChildIndex);

        while (true) {
            var leftChild = getChild(parent);
            var rightChild = leftChild + 1;
            if (leftChild > data.size() - 1 || rightChild > data.size() - 1) {
                break;
            }
            var childWithGreaterValue = Math.max(leftChild, rightChild);
            swapWithChild(parent, childWithGreaterValue);
            parent = childWithGreaterValue;
        }
    }

    private void swapWithChild(int parentIndex, int leftChildIndex) {
        var leftChildValue = data.get(leftChildIndex);
        var parentValue = data.get(parentIndex);
        data.set(leftChildIndex, parentValue);
        data.set(parentIndex, leftChildValue);
    }

    private int getChild(int elementIndex) {
        return Math.min(elementIndex * 2 + 1, data.size());
    }

}


