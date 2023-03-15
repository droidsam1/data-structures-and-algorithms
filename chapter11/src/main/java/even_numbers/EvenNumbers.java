package even_numbers;

import java.util.ArrayList;
import java.util.List;

public class EvenNumbers {

    private EvenNumbers() {
    }

    public static int[] getEvenNumbers(int[] input) {
        return getEvenNumbers(input, 0, new ArrayList<>()).stream().mapToInt(i -> i).toArray();
    }

    private static List<Integer> getEvenNumbers(int[] input, int index, List<Integer> result) {
        if (index == input.length) {
            return result;
        }
        if (input[index] % 2 == 0) {
            result.add(input[index]);
        }
        return getEvenNumbers(input, ++index, result);

    }
}
