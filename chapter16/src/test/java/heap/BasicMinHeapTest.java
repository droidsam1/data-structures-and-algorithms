package heap;

import static heap.RandomUtils.generateRandomInput;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        var input = new Integer[]{0, 7, 2, 4, 9, 3, 6, 1};
        var heap = new BasicMinHeap<>(input);

        assertEquals(0, heap.pop());
        assertEquals(1, heap.pop());
        assertEquals(2, heap.pop());
        assertEquals(3, heap.pop());
        assertEquals(4, heap.pop());
        assertEquals(6, heap.pop());
        assertEquals(7, heap.pop());
        assertEquals(9, heap.pop());
    }

    @Test
    void shouldTopElementAlwaysBeTheMinEvenForBigInputs() {
        var input = generateRandomInput();
        var expectedOutput = Arrays.stream(input)
                                   .sorted(Comparator.naturalOrder())
                                   .collect(Collectors.toCollection(ArrayDeque::new));

        var heap = new BasicMinHeap<>(input);

        while (!heap.isEmpty()) {
            assertEquals(expectedOutput.pop(), heap.pop());
        }
    }
}
