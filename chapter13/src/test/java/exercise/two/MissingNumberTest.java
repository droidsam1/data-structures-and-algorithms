package exercise.two;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class MissingNumberTest {


    @Test
    void shouldReturnNullIfNotMissingNumber() {
        var input = new int[]{0};

        var result = MissingNumber.in(input);
        assertNull(result);
    }

    @Test
    void shouldReturnMissingNumber() {
        var input = new int[]{0, 2};
        var expectedMissingNumber = 1;

        var result = MissingNumber.in(input);
        assertEquals(expectedMissingNumber, result);
    }

    @Test
    void shouldReturnMissingNumberInUnorderedInput() {
        var input = new int[]{9,3,2,5,6,7,1,0,4};
        var expectedMissingNumber = 8;

        var result = MissingNumber.in(input);
        assertEquals(expectedMissingNumber, result);
    }

}
