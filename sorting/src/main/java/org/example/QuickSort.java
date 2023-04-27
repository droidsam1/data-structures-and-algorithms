package org.example;


//Good visual explanation here: https://www.youtube.com/watch?v=WprjBK0p6rw
//Impl reference : https://www.baeldung.com/java-quicksort
public class QuickSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] input) {
        var aCopy = input.clone();
        quickSort(aCopy, 0, aCopy.length - 1);
        return aCopy;
    }

    private void quickSort(int[] aCopy, int fromIndex, int toIndex) {

        if (fromIndex > toIndex) {
            return;
        }

        var pivotIndex = toIndex;
        var swapMarker = fromIndex;

        for (int currentIndex = fromIndex; currentIndex < toIndex; currentIndex++) {
            if (aCopy[currentIndex] <= aCopy[pivotIndex]) {
                if (swapMarker < currentIndex) {
                    //swap
                    var temp = aCopy[currentIndex];
                    aCopy[currentIndex] = aCopy[swapMarker];
                    aCopy[swapMarker] = temp;
                }
                swapMarker++;
            }
        }
        //swap
        var temp = aCopy[swapMarker];
        aCopy[swapMarker] = aCopy[pivotIndex];
        aCopy[pivotIndex] = temp;

        quickSort(aCopy, fromIndex, swapMarker - 1);
        quickSort(aCopy, swapMarker + 1, toIndex);
    }
}
