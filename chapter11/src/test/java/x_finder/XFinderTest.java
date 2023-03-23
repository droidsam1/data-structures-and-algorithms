package x_finder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class XFinderTest {


    @ParameterizedTest
    @CsvSource(value = {"x, 0", "ax, 1", "abcdfghx,7"})
    void shouldFindTheFirstXInString(String input, int expectedIndex) {
        var result = XFinder.indexOfXIn(input);

        assertEquals(expectedIndex, result);
    }

}
