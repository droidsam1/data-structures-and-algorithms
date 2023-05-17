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

        var parentIndex = Math.max(elementIndex / 2 - 1, 0);

        while (true) {
            var parent = data.get(parentIndex);
            if (currentElement.compareTo(parent) > 0) {
                data.set(elementIndex, parent);
                data.set(parentIndex, currentElement);
                parentIndex = Math.max(parentIndex / 2 - 1, 0);
            } else {
                break;
            }
        }

    }


    public T getTopElement() {
        return data.get(0);
    }
}


