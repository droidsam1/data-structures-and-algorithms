import find_first_duplicate.FirstDuplicate;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FirstDuplicateTest {

    private static Stream<Arguments> arraysWithoutDuplicates() {
        return Stream.of(
                Arguments.of((Object) new String[]{}),
                Arguments.of((Object) new String[]{"a", "b"}),
                Arguments.of((Object) new String[]{"1", "2", "a"})
        );
    }

    private static Stream<Arguments> arraysWithDuplicates() {
        return Stream.of(
                Arguments.of(new String[]{"a", "a"}, "a"),
                Arguments.of(new String[]{"b", "b"}, "b"),
                Arguments.of(new String[]{"b", "a", "c", "a", "b"}, "a"),
                Arguments.of(new String[]{"b", "a", "z", "p", "j", "f", "f"}, "f"),
                Arguments.of(new String[]{"1", "a", "z", "p", "f", "1", "f"}, "1")
        );
    }

    @ParameterizedTest @MethodSource("arraysWithoutDuplicates")
    void shouldReturnEmptyIfThereIsNoDuplicates(String[] input) {

        var duplicates = FirstDuplicate.find(input);

        Assertions.assertArrayEquals(new String[]{}, duplicates);
    }

    @ParameterizedTest @MethodSource("arraysWithDuplicates") void shouldReturnFirstDuplicate(
            String[] input, String firstDuplicate
    ) {

        var duplicates = FirstDuplicate.find(input);

        Assertions.assertArrayEquals(new String[]{firstDuplicate}, duplicates);
    }

}
