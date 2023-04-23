package org.example;

public class Sorting {

    private Sorting() {
    }

    public static int[] bubbleSort(int[] input) {
        var copy = input.clone();
        boolean isSorted = false;
        while(!isSorted){
            isSorted = true;
            for (int i = 0; i < copy.length - 1; i++) {
                if (copy[i] > copy[i + 1]) {
                    var tmp = copy[i];
                    copy[i] = copy[i + 1];
                    copy[i + 1] = tmp;
                    isSorted= false;
                }
            }
        }


        return copy;
    }


}
