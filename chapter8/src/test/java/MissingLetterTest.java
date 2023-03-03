import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import missing_letter.MissingLetter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MissingLetterTest {

    private static final String ALPHABET_LETTERS = "abcdefghijklmnopqrstuvwxyz";

    private static final int N_REPETITIONS_FOR_TEST = 10;

    private static Stream<Arguments> generateRandomLetter() {
        Random r = new Random();
        return IntStream.range(0, N_REPETITIONS_FOR_TEST).mapToObj((i) -> Arguments.of((char) (r.nextInt(26) + 'a')));
    }

    @ParameterizedTest @MethodSource("generateRandomLetter")
    void shouldReturnTheMissingLetter(char expectedMissingLetter) {
        var input = getStringWithAllLettersExcept(expectedMissingLetter);

        var missingLetter = MissingLetter.findMissingLetterIn(input);

        assertEquals(expectedMissingLetter, missingLetter);
    }

    private String getStringWithAllLettersExcept(char letter) {
        return ALPHABET_LETTERS.replaceAll(String.valueOf(letter), "");
    }

}
