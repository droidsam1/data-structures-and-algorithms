import findFirstDuplicate.FirsDuplicate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FirstDuplicateTest {

    @Test void shouldReturnEmptyIfThereIsNoDuplicates() {
        var input = new int[]{};

        var duplicates = FirsDuplicate.find(input);

        Assertions.assertArrayEquals(new int[]{}, duplicates);
    }

}
