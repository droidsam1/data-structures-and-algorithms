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

    @Test void shouldReverseTwoCharLengthStrings() {
        var firstLetter = getRandomLetter();
        var secondLetter = getRandomLetter();
        var input = String.valueOf(firstLetter) + secondLetter;
        var expected = String.valueOf(secondLetter) + firstLetter;

        var actual = ReverseString.reverse(input);

        Assertions.assertEquals(expected, actual);
    }

    @Test void shouldReverseThreeCharLengthStrings() {
        var firstLetter = getRandomLetter();
        var secondLetter = getRandomLetter();
        var thirdLetter = getRandomLetter();
        var input = String.valueOf(firstLetter) + secondLetter + thirdLetter;

        var expected = String.valueOf(thirdLetter) + secondLetter + firstLetter;

        var actual = ReverseString.reverse(input);

        Assertions.assertEquals(expected, actual);
    }

    private char getRandomLetter() {
        Random r = new Random();
        return (char) (r.nextInt(26) + 'a');
    }

}
