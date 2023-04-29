package exercise.three;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GreatestNumberInArrayTest {


    @Test
    void shouldReturnTheGreatestNumberInArray() {
        var input = new int[]{1, 2, 3};
        var expectedGreatestNumber = 3;

        var result = GreatestNumberInArray.in(input);
        Assertions.assertEquals(expectedGreatestNumber, result);
    }
}
