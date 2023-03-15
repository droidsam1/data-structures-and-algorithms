package even_numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class EvenNumbersTest {

    @Test void shouldReturnEvenNumbersOnly() {
        var input = new int[]{2};
        var expected = new int[]{2};

        var result = EvenNumbers.getEvenNumbers(input);

        Assertions.assertArrayEquals(expected, result);
    }

}
