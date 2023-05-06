package tree;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {


    @Test
    void shouldBeAbleToCreateFromArray() {
        var inputArray = new Integer[]{1, 2, 3};

        var binarySearchTree = new BinarySearchTree<>(inputArray);

        assertNotNull(binarySearchTree);
        assertTrue(binarySearchTree.contains(1));
        assertTrue(binarySearchTree.contains(2));
        assertTrue(binarySearchTree.contains(3));
    }

}
