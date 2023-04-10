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
        sortInPlace(aCopy);
        return aCopy;
    }

    private static void sortInPlace(int[] input) {
        var isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < input.length - 1; i++) {
                if (input[i] < input[i + 1]) {
                    var temp = input[i];
                    input[i] = input[i + 1];
                    input[i + 1] = temp;
                    isSorted = false;
                }
            }
        }
    }
}
