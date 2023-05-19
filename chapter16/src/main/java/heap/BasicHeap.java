package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.IntPredicate;

public class BasicHeap<T extends Comparable<? super T>> {


    private final List<T> data;
    private final Comparator<T> comparator;

    public BasicHeap(Comparator<T> comparator) {
        this.data = new ArrayList<>();
        this.comparator = comparator;
    }

    public void add(T number) {
        this.data.add(number);
        if (comparator.compare(number, this.data.get(0)) > 0) {
            trickleUp(this.data.size() - 1);
        }

    }

    private void trickleUp(int elementIndex) {
        var currentElement = data.get(elementIndex);
        var parentIndex = getParentOf(elementIndex);
        var parent = data.get(parentIndex);

        if (comparator.compare(currentElement, parent) > 0) {
            data.set(elementIndex, parent);
            data.set(parentIndex, currentElement);
            trickleUp(parentIndex);
        }
    }

    private int getParentOf(int elementIndex) {
        return Math.max((elementIndex - 1) / 2, 0);
    }


    public T peek() {
        return data.get(0);
    }

    public T pop() {
        var topElement = data.get(0);
        var lastChild = data.get(data.size() - 1);
        data.set(0, lastChild);
        data.remove(data.size() - 1);
        trickleDown(0);
        return topElement;
    }

    private void trickleDown(int parent) {
        var greatestChild = findGreatestChildOf(parent).stream().filter(valueGreaterThan(parent)).findFirst();
        if (greatestChild.isPresent()) {
            swapValuesAtIndex(parent, greatestChild.getAsInt());
            trickleDown(greatestChild.getAsInt());
        }
    }

    private IntPredicate valueGreaterThan(int elementIndex) {
        return value -> comparator.compare(data.get(value), data.get(elementIndex)) > 0;
    }

    private int getChild(int elementIndex) {
        return (elementIndex + 1) * 2;
    }

    private OptionalInt findGreatestChildOf(int parent) {
        var rightChild = getChild(parent);
        var leftChild = rightChild - 1;

        if (leftChild <= data.size() - 1 && rightChild <= data.size() - 1) {
            if (comparator.compare(data.get(leftChild), data.get(rightChild)) > 0) {
                return OptionalInt.of(leftChild);
            } else {
                return OptionalInt.of(rightChild);
            }
        }

        if (leftChild <= data.size() - 1 && comparator.compare(data.get(leftChild), data.get(parent)) > 0) {
            return OptionalInt.of(leftChild);
        }

        if (rightChild <= data.size() - 1 && comparator.compare(data.get(rightChild), data.get(parent)) > 0) {
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

    public boolean isEmpty() {
        return data.isEmpty();
    }
}


