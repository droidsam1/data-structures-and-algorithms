package exercise.one;

public class GreatestProductOfAnyThree {

    private GreatestProductOfAnyThree() {
    }

    public static int of(int[] input) {
        if (input.length < 3) {
            throw new IllegalArgumentException(
                    "Cannot calculate the greatest product of three values if input array has less than three values");
        }

        return input[0] * input[1] * input[2];
    }
}
