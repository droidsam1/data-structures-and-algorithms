package heap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BasicMaxHeapTest {


    @Test
    void shouldCreateAHeap() {

        var heap = new BasicMaxHeap();

        Assertions.assertNotNull(heap);

    }

}
