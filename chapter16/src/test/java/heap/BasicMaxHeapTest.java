package heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        assertEquals(expectedTopElement, heap.peek());
    }

    @Test
    void shouldAllowToAddElements() {
        var heap = new BasicMaxHeap<Integer>();
        var inputList = List.of(55, 22, 34, 10, 2, 99);
        for (Integer number : inputList) {
            heap.add(number);
        }
        assertEquals(max(inputList), heap.peek());
    }

    private <T extends Comparable<? super T>> T max(List<T> list) {
        return list.stream().max(Comparator.naturalOrder()).orElseThrow();
    }

    @Test
    void shouldReturnTrueWhenHeapIsEmpty() {
        var heap = new BasicMaxHeap<>();

        assertTrue(heap.isEmpty());
    }

    @Test
    void shouldReturnFalseWhenHeapIsEmpty() {
        var heap = new BasicMaxHeap<Integer>();
        heap.add(1);

        assertFalse(heap.isEmpty());
    }

    @Test
    void shouldTopElementAlwaysBeTheMax() {
        var heap = new BasicMaxHeap<Integer>();
        var inputList = List.of(55, 22, 34, 10, 2, 99);
        for (Integer number : inputList) {
            heap.add(number);
        }

        assertEquals(99, heap.pop());
        assertEquals(55, heap.pop());
        assertEquals(34, heap.pop());
        assertEquals(22, heap.pop());
        assertEquals(10, heap.pop());
    }

    @Test
    void shouldTopElementAlwaysBeTheMaxEvenForBigInputs() {
        var input = RandomUtils.generateRandomInput();
        var expectedOutputOrder = Arrays.stream(input)
                                        .sorted(Comparator.reverseOrder())
                                        .collect(Collectors.toCollection(ArrayDeque::new));

        var heap = new BasicMaxHeap<>(input);

        while (!heap.isEmpty()) {
            assertEquals(expectedOutputOrder.pop(), heap.pop());
        }
    }
}
