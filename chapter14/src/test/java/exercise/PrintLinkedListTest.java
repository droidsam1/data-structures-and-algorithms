package exercise;

import static org.junit.jupiter.api.Assertions.assertTrue;

import linkedlist.NaiveLinkedList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrintLinkedListTest {

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
    void shouldPrintAllElementsInList() {
        var input = new NaiveLinkedList<>(List.of(1, 2, 3, 4, 5));

        input.print();

        assertTrue(mockedSystemOut.toString().contains("1"));
        assertTrue(mockedSystemOut.toString().contains("2"));
        assertTrue(mockedSystemOut.toString().contains("3"));
        assertTrue(mockedSystemOut.toString().contains("4"));
        assertTrue(mockedSystemOut.toString().contains("5"));
    }

}
