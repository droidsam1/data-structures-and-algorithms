package org.example;

public class InsertionSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] input) {
        var inputCopy = input.clone();
        for (int i = 1; i < inputCopy.length; i++) {
            var pivot = inputCopy[i - 1];
            if (inputCopy[i] < pivot) {
                var tmp = inputCopy[i];
                var j = i - 1;
                while (j >= 0 && tmp < inputCopy[j]) {
                    var tmp1 = inputCopy[j];
                    inputCopy[j] = inputCopy[j + 1];
                    inputCopy[j + 1] = tmp1;
                    j--;
                }
            }
        }
        return inputCopy;
    }
}
