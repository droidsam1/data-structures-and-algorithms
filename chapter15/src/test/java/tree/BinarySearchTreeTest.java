package tree;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    private ByteArrayOutputStream fakeOutput;

    @BeforeEach
    public void setup() {
        this.fakeOutput = new ByteArrayOutputStream();
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
    void shouldPrintPreOrderTraversal() {
        var inputArray = new Integer[]{1, 5, 9, 2, 4, 10, 6, 3, 8};

        var binarySearchTree = new BinarySearchTree<>(inputArray, new PrintStream(fakeOutput));
        binarySearchTree.preOrderTraversalPrint();

        assertEquals("1 5 2 4 3 9 6 8 10", fakeOutput.toString(UTF_8).trim());
    }

    @Test
    void shouldPrintInOrderTraversal() {
        var inputArray = new Integer[]{1, 5, 9, 2, 4, 10, 6, 3, 8};

        var binarySearchTree = new BinarySearchTree<>(inputArray, new PrintStream(fakeOutput));
        binarySearchTree.inOrderTraversalPrint();

        assertEquals("1 2 3 4 5 6 8 9 10", fakeOutput.toString(UTF_8).trim());
    }

    @Test
    void shouldPrintPostOrderTraversal() {
        var inputArray = new Integer[]{1, 5, 9, 2, 4, 10, 6, 3, 8};

        var binarySearchTree = new BinarySearchTree<>(inputArray, new PrintStream(fakeOutput));
        binarySearchTree.postOrderTraversalPrint();

        assertEquals("3 4 2 8 6 10 9 5 1", fakeOutput.toString(UTF_8).trim());
    }

    @Test
    void shouldPrintPostOrderForTheExampleOfTheBook() {
        var fakeOutput = new ByteArrayOutputStream();

        var inputArray = new String[]{
                "Moby Dick",
                "Great Expectations",
                "Robinson Crusoe",
                "Alice in Wonderland",
                "Lord of the Flies",
                "Pride and Prejudice",
                "The Odyssey"
        };

        var binarySearchTree = new BinarySearchTree<>(inputArray, new PrintStream(fakeOutput));
        binarySearchTree.postOrderTraversalPrint();

        assertEquals(
                "Alice in Wonderland Lord of the Flies Great Expectations Pride and Prejudice The Odyssey Robinson Crusoe Moby Dick",
                fakeOutput.toString(UTF_8).trim()
        );
    }


}
