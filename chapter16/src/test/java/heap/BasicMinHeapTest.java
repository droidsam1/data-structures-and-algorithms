package heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
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

        assertEquals(expectedTopElement, heap.peek());
    }

    @Test
    void shouldAllowToAddElements() {
        var heap = new BasicMinHeap<Integer>();
        var inputList = List.of(55, 22, 34, 10, 2, 99);
        for (Integer number : inputList) {
            heap.add(number);
        }
        assertEquals(min(inputList), heap.peek());
    }

    private <T extends Comparable<? super T>> T min(List<T> list) {
        return list.stream().min(Comparator.naturalOrder()).orElseThrow();
    }

    @Test
    void shouldTopElementAlwaysBeTheMin() {
        var heap = new BasicMinHeap<Integer>();
        var inputList = List.of(55, 22, 34, 10, 2, 99);
        for (Integer number : inputList) {
            heap.add(number);
        }
        assertEquals(2, heap.pop());
        assertEquals(10, heap.pop());
        assertEquals(22, heap.pop());
        assertEquals(34, heap.pop());
        assertEquals(55, heap.pop());
        assertEquals(99, heap.pop());
    }


    @Test
    void shouldPopTheTopElement() {
        var input = new Integer[]{2, 22, 34, 10};

        var heap = new BasicMinHeap<>(input);

        assertEquals(2, heap.pop());
        assertEquals(10, heap.pop());
        assertEquals(22, heap.pop());
        assertEquals(34, heap.pop());
    }

    @Test
    void shouldTheMinElementBeAtTheTop() {
        var input = new Integer[]{2, 22, 34, 10};
        var expectedOutputOrder = Arrays.stream(input)
                                        .sorted(Comparator.naturalOrder())
                                        .collect(Collectors.toCollection(ArrayDeque::new));

        var heap = new BasicMinHeap<>(input);

        while (!heap.isEmpty()) {
            assertEquals(expectedOutputOrder.pop(), heap.pop());
        }
    }
}
