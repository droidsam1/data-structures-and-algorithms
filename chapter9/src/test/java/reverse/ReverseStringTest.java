package reverse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ReverseStringTest {


    @Test void shouldReverse() {
        var input = "a";
        var expected = "a";

        var actual = ReverseString.reverse(input);

        Assertions.assertEquals(expected, actual);
    }

}
