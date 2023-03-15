package even_numbers;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class EvenNumbersTest {

    private static Stream<Arguments> shouldReturnEvenNumbersOnly() {
        return Stream.of(
                Arguments.of(new int[]{2}, new int[]{2}),//
                Arguments.of(new int[]{1, 2}, new int[]{2}),//
                Arguments.of(new int[]{1, 2, 3, 4}, new int[]{2, 4}), //
                Arguments.of(new int[]{0, 1, 2, 3, 4, 5, 6, 8, 10, 20, 22}, new int[]{0, 2, 4, 6, 8, 10, 20, 22})
        );
    }


    @ParameterizedTest @MethodSource void shouldReturnEvenNumbersOnly(int[] input, int[] expected) {

        var result = EvenNumbers.getEvenNumbers(input);

        Assertions.assertArrayEquals(expected, result);
    }

}
