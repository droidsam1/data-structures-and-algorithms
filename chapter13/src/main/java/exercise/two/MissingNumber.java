package exercise.two;

import java.util.stream.IntStream;

public class MissingNumber {

    private MissingNumber() {
    }

    public static Integer in(int[] input) {
        var sortedInput = sort(input);
        for (int i = 0; i < sortedInput.length; i++) {
            if (sortedInput[i] != i) {
                return i;
            }
        }
        return null;
    }

    private static int[] sort(int[] input) {
        if (input.length < 2) {
            return input;
        }
        if (input.length == 2) {
            if (input[0] > input[1]) {
                var tmp = input[0];
                input[0] = input[1];
                input[1] = tmp;
            }
            return input;
        } else {
            var middle = input.length / 2;

            var left = IntStream.of(input).limit(middle).toArray();
            var right = IntStream.of(input).skip(middle).toArray();

            return merge(sort(left), sort(right));
        }

    }


    private static int[] merge(int[] left, int[] right) {
        var result = new int[left.length + right.length];

        int j = 0;
        int k = 0;
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
