package even_numbers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class EvenNumbers {

    private EvenNumbers() {
    }

    public static int[] getEvenNumbers(int[] input) {
        if (input.length == 0) {
            return new int[]{};
        }

        if (input.length == 1) {
            if (input[0] % 2 == 0) {
                return new int[]{input[0]};
            }
            return new int[]{};
        }

        return IntStream.concat(
                Arrays.stream(getEvenNumbers(Arrays.copyOfRange(input, 0, 1))),
                Arrays.stream(getEvenNumbers(Arrays.copyOfRange(input, 1, input.length)))
        ).toArray();
    }
}
