package exercise.two;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MissingNumberTest {


    @Test
    void shouldReturnNullIfNotMissingNumber() {
        var input = new int[]{0};

        var result = MissingNumber.of(input);
        Assertions.assertNull(result);
    }


}
