package tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {


    @Test
    void shouldBeAbleToCreateFromArray() {
        var inputArray = new Integer[]{1, 2, 3, 10, 7, 0, 8, 4};

        var binarySearchTree = new BinarySearchTree<>(inputArray);

        assertNotNull(binarySearchTree);
        assertTrue(binarySearchTree.contains(1));
        assertTrue(binarySearchTree.contains(10));
        assertTrue(binarySearchTree.contains(4));
    }


    @Test
    void shouldFindTheGreatest() {
        var inputArray = new Integer[]{1, 2, 3, 10, 7, 0, 8, 4};

        var binarySearchTree = new BinarySearchTree<>(inputArray);

        assertEquals(10, binarySearchTree.getGreatestValue());
    }


}
