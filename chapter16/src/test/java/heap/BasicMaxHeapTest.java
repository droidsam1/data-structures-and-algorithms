package heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BasicMaxHeapTest {

    private static Stream<Object> shouldReturnTheMax() {
        return Stream.of(
                Arguments.of(new Integer[]{55}, 55),
                Arguments.of(new Integer[]{55, 10}, 55),
                Arguments.of(new Integer[]{10, 55}, 55),
                Arguments.of(new Integer[]{2, 22, 34, 10}, 34),
                Arguments.of(new Integer[]{55, 22, 34, 10, 2, 99, 68}, 99)
        );
    }

    @ParameterizedTest
    @MethodSource
    void shouldReturnTheMax(Integer[] input, Integer expectedTopElement) {
        var heap = new BasicMaxHeap<>(input);

        assertEquals(expectedTopElement, heap.getTopElement());
    }

    @Test
    void shouldPopTheTopElement() {
        var input = new Integer[]{2, 22, 34, 10};

        var heap = new BasicMaxHeap<>(input);

        assertEquals(34, heap.pop());
        assertEquals(22, heap.pop());
        assertEquals(10, heap.pop());
        assertEquals(2, heap.pop());
    }
}
