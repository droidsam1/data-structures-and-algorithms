package org.example;

import java.util.Arrays;

public class MergeSort implements SortingAlgorithm {

    @Override
    public int[] sort(int[] input) {
        return mergeSort(input.clone());
    }

    private int[] mergeSort(int[] input) {
        if (input.length < 2) {
            return input;
        }

        var middle = input.length / 2;

        var left = Arrays.stream(input).limit(middle).toArray();
        var right = Arrays.stream(input).skip(middle).toArray();

        return merge(mergeSort(left), mergeSort(right));

    }

    private int[] merge(int[] left, int[] right) {
        var result = new int[left.length + right.length];
        var j = 0;
        var k = 0;
        for (int i = 0; i < result.length; i++) {
            if (j < left.length && (k >= right.length || left[j] < right[k])) {
                result[i] = left[j++];
            } else {
                result[i] = right[k++];
            }
        }
        return result;
    }
}
