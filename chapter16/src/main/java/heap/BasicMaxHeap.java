package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;

public class BasicMaxHeap<T extends Comparable<? super T>> {


    private final List<T> data;

    public BasicMaxHeap() {
        this.data = new ArrayList<>();
    }

    public BasicMaxHeap(T[] input) {
        this();
        this.data.add(input[0]);
        for (int i = 1; i < input.length; i++) {
            this.data.add(input[i]);
            if (input[i].compareTo(this.data.get(0)) > 0) {
                trickleUpNodeAtIndex(i);
            }
        }

    }

    private void trickleUpNodeAtIndex(int elementIndex) {
        var currentElement = data.get(elementIndex);
        var parentIndex = getParentOf(elementIndex);

        while (true) {
            var parent = data.get(parentIndex);
            if (currentElement.compareTo(parent) > 0) {
                data.set(elementIndex, parent);
                data.set(parentIndex, currentElement);
                elementIndex = parentIndex;
                parentIndex = getParentOf(parentIndex);
            } else {
                break;
            }
        }

    }

    private int getParentOf(int elementIndex) {
        return Math.max((elementIndex - 1) / 2, 0);
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

        while (parent < data.size() - 1) {
            var leftChild = getChild(parent);
            var rightChild = leftChild - 1;
            var greatestChild = getGreatestChild(leftChild, rightChild, parent);
            if (greatestChild.isPresent()) {
                swapValuesAtIndex(parent, greatestChild.getAsInt());
                parent = leftChild;
            } else {
                break;
            }
        }
    }

    private OptionalInt getGreatestChild(int leftChild, int rightChild, int parent) {
        if (leftChild <= data.size() - 1 && rightChild <= data.size() - 1) {
            if ((data.get(leftChild).compareTo(data.get(rightChild)) > 0)) {
                return OptionalInt.of(leftChild);
            } else {
                return OptionalInt.of(rightChild);
            }
        }

        if (leftChild <= data.size() - 1 && data.get(leftChild).compareTo(data.get(parent)) > 0) {
            return OptionalInt.of(leftChild);
        }

        if (rightChild <= data.size() - 1 && data.get(rightChild).compareTo(data.get(parent)) > 0) {
            return OptionalInt.of(rightChild);
        }
        return OptionalInt.empty();
    }

    private void swapValuesAtIndex(int parentIndex, int childIndex) {
        var leftChildValue = data.get(childIndex);
        var parentValue = data.get(parentIndex);
        data.set(childIndex, parentValue);
        data.set(parentIndex, leftChildValue);
    }

    private int getChild(int elementIndex) {
        return (elementIndex + 1) * 2;
    }

    public void add(T number) {
        this.data.add(number);
        if (number.compareTo(this.data.get(0)) > 0) {
            trickleUpNodeAtIndex(this.data.size() - 1);
        }
    }
}


