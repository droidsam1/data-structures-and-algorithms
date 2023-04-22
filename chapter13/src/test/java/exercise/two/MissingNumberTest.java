package exercise.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MissingNumberTest {


    @Test
    void shouldReturnNullIfNotMissingNumber() {
        var input = new int[]{0};

        var result = MissingNumber.in(input);
        Assertions.assertNull(result);
    }

    @Test
    void shouldReturnMissingNumber() {
        var input = new int[]{0, 2};
        var expectedMissingNumber = 1;

        var result = MissingNumber.in(input);
        Assertions.assertEquals(expectedMissingNumber, result);
    }

}
