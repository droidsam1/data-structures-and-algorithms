package triangular_numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TriangularNumbersTest {


    @ParameterizedTest
    @CsvSource(value = {"1,1"})
    void shouldReturnTheNthNumberInTheTriangularSequence(int input, int expected) {

        var result = TriangularNumbers.getNth(input);

        assertEquals(expected, result);
    }


}
