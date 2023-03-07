package reverse;

import java.util.Random;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ReverseStringTest {


    @Test void shouldReverseOneCharLengthStrings() {
        var input = String.valueOf(getRandomLetter());

        var actual = ReverseString.reverse(input);

        Assertions.assertEquals(input, actual);
    }

    private char getRandomLetter() {
        Random r = new Random();
        return (char) (r.nextInt(26) + 'a');
    }

}
