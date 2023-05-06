package tree;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    private PrintStream originalOutput;
    private ByteArrayOutputStream fakeOutput;

    @BeforeEach
    public void setup() {
        this.originalOutput = System.out;
        this.fakeOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(this.fakeOutput));
    }

    @AfterEach
    public void cleanUp() {
        System.setOut(this.originalOutput);
    }


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

    @Test
    void shouldPrintPreorderTraversal() {
        var inputArray = new Integer[]{1, 5, 9, 2, 4, 10, 6, 3, 8};

        var binarySearchTree = new BinarySearchTree<>(inputArray);
        binarySearchTree.preorderTraversalPrint();

        assertEquals("1 5 2 4 3 9 6 8 10", fakeOutput.toString(UTF_8).trim());
    }


}
