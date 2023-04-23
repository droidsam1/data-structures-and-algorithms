package org.example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SortingTest {

    public static Stream<Arguments> shouldSortInput() {
        return Stream.of(
                Arguments.of(new BubbleSort(), generateRandomArray()),
                Arguments.of(new SelectionSort(), generateRandomArray()),
                Arguments.of(new InsertionSort(), generateRandomArray())
        );
    }

    private static int[] generateRandomArray() {
        return IntStream.generate(() -> new Random().nextInt(100) + 100).limit(1000).toArray();
    }

    @ParameterizedTest
    @MethodSource("shouldSortInput")
    void shouldSortInput(SortingAlgorithm sortingAlgorithm, int[] input) {
        int[] result = sortingAlgorithm.sort(input);

        assertArrayEquals(Arrays.stream(input).sorted().toArray(), result);
    }

}
