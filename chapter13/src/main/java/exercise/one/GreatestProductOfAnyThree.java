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
        if (input[0] > input[input.length - 1]) {
            return new int[]{input[0], input[1], input[2]};
        } else {
            return new int[]{input[input.length - 1], input[input.length - 2], input[input.length - 3]};
        }

    }
}
