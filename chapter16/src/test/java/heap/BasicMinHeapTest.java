package heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BasicMinHeapTest {

    private static Stream<Object> shouldReturnTheMax() {
        return Stream.of(
                Arguments.of(new Integer[]{55}, 55),
                Arguments.of(new Integer[]{55, 10}, 10),
                Arguments.of(new Integer[]{10, 55}, 10),
                Arguments.of(new Integer[]{10, 22, 34, 2}, 2),
                Arguments.of(new Integer[]{55, 22, 34, 10, 2, 99, 68}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource
    void shouldReturnTheMax(Integer[] input, Integer expectedTopElement) {
        var heap = new BasicMinHeap<>(input);

        assertEquals(expectedTopElement, heap.getTopElement());
    }
}
