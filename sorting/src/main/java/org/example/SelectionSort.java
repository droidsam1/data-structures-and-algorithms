package org.example;

public class SelectionSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] input) {
        var inputCopy = input.clone();

        for (int minIndex = 0; minIndex < inputCopy.length; minIndex++) {
            for (int i = minIndex; i < inputCopy.length; i++) {
                if (inputCopy[i] < inputCopy[minIndex]) {
                    var tmp = inputCopy[minIndex];
                    inputCopy[minIndex] = inputCopy[i];
                    inputCopy[i] = tmp;
                }
            }
        }
        return inputCopy;
    }
}
