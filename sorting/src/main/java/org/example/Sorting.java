package org.example;

public class Sorting {

    private Sorting() {
    }

    public static int[] bubbleSort(int[] input) {
        var copy = input.clone();
        if (copy[0] > copy[1]) {
            var tmp = copy[0];
            copy[0] = copy[1];
            copy[1] = tmp;
        }

        return copy;
    }


}
