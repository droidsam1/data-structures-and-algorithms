import findFirstDuplicate.FirsDuplicate;
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

    @ParameterizedTest @MethodSource("arraysWithoutDuplicates")
    void shouldReturnEmptyIfThereIsNoDuplicates(String[] input) {

        var duplicates = FirsDuplicate.find(input);

        Assertions.assertArrayEquals(new String[]{}, duplicates);
    }

}
