import find_first_non_duplicated_letter.FirstNonDuplicate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FirstNonDuplicateTest {

    @ParameterizedTest
    @CsvSource({"m,m", "n,n", "A,A", "z,z", "mmn,n"})
    void shouldReturnTheFirstNonDuplicateLetter(String input, String expected) {

        var firstNonDuplicate = FirstNonDuplicate.find(input);

        Assertions.assertEquals(expected.charAt(0), firstNonDuplicate);
    }


    @Disabled("while developing") @Test void shouldReturnTheFirstNonDuplicatedLetter() {
        var input = "minimum";

        var firstNonDuplicate = FirstNonDuplicate.find(input);

        Assertions.assertEquals('n', firstNonDuplicate);
    }
}
