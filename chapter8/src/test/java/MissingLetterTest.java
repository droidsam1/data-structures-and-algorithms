import static org.junit.jupiter.api.Assertions.assertEquals;

import missing_letter.MissingLetter;
import org.junit.jupiter.api.Test;

public class MissingLetterTest {


    private static final String ALPHABET_LETTERS = "abcdefghijklmnopqrstuvwxyz";

    @Test void shouldReturnTheMissingLetter() {
        var expectedMissingLetter = 'a';
        var input = getStringWithAllLettersExcept(expectedMissingLetter);

        var missingLetter = MissingLetter.findMissingLetterIn(input);

        assertEquals(expectedMissingLetter, missingLetter);
    }

    private String getStringWithAllLettersExcept(char letter) {
        return ALPHABET_LETTERS.replaceAll(String.valueOf(letter), "");
    }

}
