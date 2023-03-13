package count_all_chars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CountAllCharsTest {


    public static Stream<Arguments> shouldPrintAllChars() {
        return Stream.of(
                Arguments.of(new String[]{"a"}, 1), //
                Arguments.of(new String[]{""}, 0) //
        );
    }

    @ParameterizedTest @MethodSource void shouldPrintAllChars(String[] input, int expectedCountedChars) {

        var actualCountedChars = CountAllChars.count(input);

        assertEquals(expectedCountedChars, actualCountedChars);
    }

}
