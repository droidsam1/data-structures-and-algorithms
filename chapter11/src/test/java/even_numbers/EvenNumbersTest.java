package even_numbers;

import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class EvenNumbersTest {

    private static Stream<Arguments> shouldReturnEvenNumbersOnly() {
        return Stream.of(Arguments.of(new int[]{2}, new int[]{2}));
    }


    @ParameterizedTest @MethodSource void shouldReturnEvenNumbersOnly(int[] input, int[] expected) {

        var result = EvenNumbers.getEvenNumbers(input);

        Assertions.assertArrayEquals(expected, result);
    }

}
