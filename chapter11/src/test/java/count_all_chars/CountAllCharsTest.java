package count_all_chars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CountAllCharsTest {


    public static Stream<Arguments> shouldPrintAllChars() {
        return Stream.of(
                Arguments.of(new Object[]{""}, 0), //
                Arguments.of(new Object[]{"a"}, 1), //
                Arguments.of(new Object[]{"a", "b"}, 2), //
                Arguments.of(new Object[]{"a", new String[]{"b"}}, 2), //
                Arguments.of(new Object[]{"a", new String[]{"b"}, "ab", new String[]{"ba", "ab"}}, 8) //
        );
    }

    @ParameterizedTest @MethodSource void shouldPrintAllChars(Object input, int expectedCountedChars) {

        var actualCountedChars = CountAllChars.count(input);

        assertEquals(expectedCountedChars, actualCountedChars);
    }

}
