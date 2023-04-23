package org.example;

public class MergeSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] input) {
        var aCopy = input.clone();
        mergeSort(aCopy, aCopy.length);
        return aCopy;
    }

    private void mergeSort(int[] input, int n) {
        if (n < 2) {
            return;
        }

        var middle = n / 2;

        var left = new int[middle];
        var right = new int[input.length - middle];
        for (int i = 0; i < input.length; i++) {
            if (i < middle) {
                left[i] = input[i];
            } else {
                right[i - middle] = input[i];
            }

        }
        mergeSort(left, middle);
        mergeSort(right, n - middle);
        merge(input, left, right, middle, n - middle);
    }

    private void merge(int[] originalArray, int[] left, int[] right, int leftSize, int rightSize) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                originalArray[k++] = left[i++];
            } else {
                originalArray[k++] = right[j++];
            }
        }
        while (i < leftSize) {
            originalArray[k++] = left[i++];
        }
        while (j < rightSize) {
            originalArray[k++] = right[j++];
        }
    }
}
