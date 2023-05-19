package heap;

import java.util.Comparator;

public class BasicMaxHeap<T extends Comparable<? super T>> extends BasicHeap<T> {


    public BasicMaxHeap() {
        super(Comparator.naturalOrder());
    }

    public BasicMaxHeap(T[] input) {
        this();
        for (T element : input) {
            this.add(element);
        }
    }

}


