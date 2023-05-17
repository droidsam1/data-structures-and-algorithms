package heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BasicMaxHeapTest {

    private static Stream<Object> shouldReturnTheMax() {
        return Stream.of(
                Arguments.of((Object) new Integer[]{55}),
                Arguments.of((Object) new Integer[]{55, 10}),
                Arguments.of((Object) new Integer[]{10, 55})

        );
    }

    @ParameterizedTest
    @MethodSource
    void shouldReturnTheMax(Integer[] input) {
        var heap = new BasicMaxHeap<>(input);

        assertNotNull(heap);
        assertEquals(55, heap.getTopElement());
    }

}
