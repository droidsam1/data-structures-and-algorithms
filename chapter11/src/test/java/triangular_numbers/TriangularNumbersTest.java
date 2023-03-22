package triangular_numbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TriangularNumbersTest {


    @Test void shouldReturnTheNthNumberInTheTriangularSequence() {
        var input = 1;
        var expected = 1;

        var result = TriangularNumbers.getNth(input);

        assertEquals(expected, result);
    }


}
