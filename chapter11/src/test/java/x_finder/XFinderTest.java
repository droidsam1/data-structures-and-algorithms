package x_finder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class XFinderTest {


    @Test void shouldFindTheFirstXInString() {
        var input = "x";
        var expected = 0;

        var result = XFinder.indexOfXIn(input);

        assertEquals(expected, result);
    }

}
