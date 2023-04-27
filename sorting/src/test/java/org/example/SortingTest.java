package org.example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.RepeatedTest;

class SortingTest {

    private static final int REPETITIONS = 1000;

    private static int[] generateRandomArray() {
        return IntStream.generate(() -> new Random().nextInt(100) + 100).limit(1000).toArray();
    }

    @RepeatedTest(REPETITIONS)
    void shouldSortUsingBubbleSort() {
        var input = generateRandomArray();
        int[] result = new BubbleSort().sort(input);

        assertArrayEquals(Arrays.stream(input).sorted().toArray(), result);
    }


    @RepeatedTest(REPETITIONS)
    void shouldSortUsingSelectionSort() {
        var input = generateRandomArray();
        int[] result = new SelectionSort().sort(input);

        assertArrayEquals(Arrays.stream(input).sorted().toArray(), result);
    }

    @RepeatedTest(REPETITIONS)
    void shouldSortUsingInsertionSort() {
        var input = generateRandomArray();
        int[] result = new InsertionSort().sort(input);

        assertArrayEquals(Arrays.stream(input).sorted().toArray(), result);
    }

    @RepeatedTest(REPETITIONS)
    void shouldSortUsingMergeSort() {
        var input = generateRandomArray();
        int[] result = new MergeSort().sort(input);

        assertArrayEquals(Arrays.stream(input).sorted().toArray(), result);
    }

    @RepeatedTest(REPETITIONS)
    void shouldSortUsingQuickSort() {
        var input = generateRandomArray();
        int[] result = new QuickSort().sort(input);

        assertArrayEquals(Arrays.stream(input).sorted().toArray(), result);
    }


}
