import find_first_non_duplicated_letter.FirstNonDuplicate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class FirstNonDuplicateTest {

    @Test
    void shouldReturnTheOnlyLetterIfThereIsOnlyOne(){
        var input = "m";

        var firstNonDuplicate = FirstNonDuplicate.find(input);

        Assertions.assertEquals('m', firstNonDuplicate);
    }


    @Disabled("while developing") @Test void shouldReturnTheFirstNonDuplicatedLetter() {
        var input = "minimum";

        var firstNonDuplicate = FirstNonDuplicate.find(input);

        Assertions.assertEquals('n', firstNonDuplicate);
    }
}
