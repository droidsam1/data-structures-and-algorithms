package heap;

import java.util.Comparator;

public class BasicMinHeap<T extends Comparable<? super T>> extends BasicHeap<T> {


    public BasicMinHeap() {
        super(Comparator.reverseOrder());
    }

    public BasicMinHeap(T[] input) {
        this();
        for (T element : input) {
            this.add(element);
        }
    }

}


