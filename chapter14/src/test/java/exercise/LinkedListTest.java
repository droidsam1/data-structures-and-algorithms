package exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import linkedlist.NaiveLinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    private final ByteArrayOutputStream mockedSystemOut = new ByteArrayOutputStream();
    private final PrintStream systemOut = System.out;

    @BeforeEach
    public void mockStandardOutput() {
        System.setOut(new PrintStream(mockedSystemOut));
    }

    @AfterEach
    public void restoreOutput() {
        System.setOut(systemOut);
    }

    @Test
    void shouldPrintAllElementsWhenIntegerList() {
        var input = new NaiveLinkedList<>(List.of(1, 2, 3, 4, 5));

        input.print();

        assertTrue(mockedSystemOut.toString().startsWith("1"));
        assertTrue(mockedSystemOut.toString().contains("2"));
        assertTrue(mockedSystemOut.toString().contains("3"));
        assertTrue(mockedSystemOut.toString().contains("4"));
        assertTrue(mockedSystemOut.toString().strip().endsWith("5"));
    }

    @Test
    void shouldPrintAllElementsWhenStringList() {
        var input = new NaiveLinkedList<>().add("stem").add("word").add("rule").add("another");

        input.print();

        assertTrue(mockedSystemOut.toString().startsWith("stem"));
        assertTrue(mockedSystemOut.toString().contains("word"));
        assertTrue(mockedSystemOut.toString().contains("rule"));
        assertTrue(mockedSystemOut.toString().strip().contains("another"));
    }

    @Test
    void shouldReturnLastElement() {
        var input = new NaiveLinkedList<>().add("stem").add("word").add("rule").add("another");

        assertEquals("another", input.getLast());
    }

    @Test
    void shouldReturnLastElementWhenConstructorList() {
        var input = new NaiveLinkedList<>(List.of(1, 2, 3, 4, 5));

        assertEquals(5, input.getLast());
    }

    @Test
    void shouldReverseTheList() {
        var input = new NaiveLinkedList<>().add("stem").add("word").add("rule").add("another");
        var expectedReversed = new NaiveLinkedList<>().add("another").add("rule").add("word").add("stem");

        assertEquals(expectedReversed.get(0), input.reverse().get(0));
        assertEquals(expectedReversed.get(1), input.reverse().get(1));
        assertEquals(expectedReversed.get(2), input.reverse().get(2));
        assertEquals(expectedReversed.get(3), input.reverse().get(3));
    }

}
