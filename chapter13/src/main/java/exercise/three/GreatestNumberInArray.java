package exercise.three;

public class GreatestNumberInArray {

    public static int in(int[] input) {
        return logarithmicSearch(input);
    }

    private static int sequentialSearch(int[] input) {
        int greatest = 0;
        for (int n : input) {
            if (n > greatest) {
                greatest = n;
            }
        }
        return greatest;
    }

    private static int exponentialSearch(int[] input) {
        for (int i = 0; i < input.length; i++) {
            var isTheGreatest = true;
            for (int j = i; j < input.length; j++) {
                if (input[i] < input[j]) {
                    isTheGreatest = false;
                    break;
                }
            }
            if (isTheGreatest) {
                return input[i];
            }
        }
        return input[0];
    }

    private static int logarithmicSearch(int[] input) {
        var sorted = sort(input);
        return sorted[0];
    }

    private static int[] sort(int[] input) {
        var aCopy = input.clone();
        mergeSort(aCopy);
        return aCopy;
    }

    private static void mergeSort(int[] aCopy) {
        if (aCopy.length < 2) {
            return;
        }
        var middle = aCopy.length / 2;
        var left = new int[middle];
        var right = new int[aCopy.length - middle];
        for (int i = 0; i < aCopy.length; i++) {
            if (i < middle) {
                left[i] = aCopy[i];
            } else {
                right[i - middle] = aCopy[i];
            }

        }

        mergeSort(left);
        mergeSort(right);
        merge(aCopy, left, right);
    }

    private static void merge(int[] aCopy, int[] left, int[] right) {
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = 0; i < aCopy.length; i++) {
            if (leftIndex < left.length && rightIndex < right.length) {
                if (left[leftIndex] > right[rightIndex]) {
                    aCopy[i] = left[leftIndex++];
                } else {
                    aCopy[i] = right[rightIndex++];
                }
            } else {
                if (leftIndex < left.length) {
                    aCopy[i] = left[leftIndex++];
                }
                if (rightIndex < right.length) {
                    aCopy[i] = right[rightIndex++];
                }
            }
        }

    }
}
