package exercise.one;

public class GreatestProductOfAnyThree {

    private GreatestProductOfAnyThree() {
    }

    public static int of(int[] input) {
        if (input.length < 3) {
            throw new IllegalArgumentException(
                    "Cannot calculate the greatest product of three values if input array has less than three values");
        }

        var sortedInput = sort(input);

        return sortedInput[0] * sortedInput[1] * sortedInput[2];
    }

    private static int[] sort(int[] input) {
        var aCopy = input.clone();
        return mergeSort(aCopy);
    }

    private static int[] mergeSort(int[] input) {
        //implement an insertion sort algorithm just to practice
        if (input.length == 2) {
            if (input[0] < input[1]) {
                var temp = input[0];
                input[0] = input[1];
                input[1] = temp;
                return input;
            }
        } else if (input.length > 2) {
            var middle = input.length / 2;
            var left = java.util.Arrays.stream(input, 0, middle).toArray();
            var right = java.util.Arrays.stream(input, middle, input.length).toArray();
            return merge(mergeSort(left), mergeSort(right));


        }
        return input;
    }

    private static int[] merge(int[] left, int[] right) {
        var result = new int[left.length + right.length];
        int j = 0;
        int k = 0;
        for (int i = 0; i < result.length; i++) {
            if (k < right.length && (j >= left.length || left[j] < right[k])) {
                result[i] = right[k++];
            } else if (j < left.length) {
                result[i] = left[j++];
            }

        }
        return result;
    }
}
