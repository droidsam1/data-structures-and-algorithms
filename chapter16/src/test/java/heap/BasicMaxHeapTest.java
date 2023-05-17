package heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class BasicMaxHeapTest {


    @Test
    void shouldReturnTheMax() {
        var input = new Integer[]{55};

        var heap = new BasicMaxHeap<>(input);

        assertNotNull(heap);
        assertEquals(55, heap.getTopElement());

    }

}
