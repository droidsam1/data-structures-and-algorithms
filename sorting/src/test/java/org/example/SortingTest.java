package org.example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class SortingTest {

    @Test
    void shouldSortInput() {
        int[] input = new int[]{1, 2};

        int[] result = Sorting.bubbleSort(input);

        assertArrayEquals(new int[]{1, 2}, result);
    }

}
