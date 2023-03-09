package printnumbers;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class PrintNumbersOnlyTest {

    private static final Object[] exampleArrayOfArrays = new Object[]{
            1, 2, 3, new Object[]{4, 5, 6}, 7, new Object[]{
            8, new Object[]{
            9, 10, 11, new Object[]{12, 13, 14}
    }
    }, new Object[]{
            15, 16, 17, 18, 19, new Object[]{
            20, 21, 22, new Object[]{
            23, 24, 25, new Object[]{26, 27, 28, 29}
    }, 30, 31
    }, 32
    }, 33
    };
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach public void captureOutput() {
        System.setOut(new PrintStream(outContent));
    }

    @Test void shouldPrintOnlyNumbersForSimpleArrays() {
        var input = new Object[]{1};

        PrintNumbersOnly.printOnlyNumbers(input);

        Assertions.assertTrue(outContent.toString().contains("1"));
    }

    @Test void shouldPrintOnlyNumbersForNestedArrays() {
        var input = new Object[]{new Object[]{1}};

        PrintNumbersOnly.printOnlyNumbers(input);

        Assertions.assertTrue(outContent.toString().contains("1"));
    }

    @Test void shouldPrintOnlyNumbersForNestedNestedArrays() {
        var input = new Object[]{new Object[]{new Object[]{1}}};

        PrintNumbersOnly.printOnlyNumbers(input);

        Assertions.assertTrue(outContent.toString().contains("1"));
    }

    @Test @Disabled("while developing") void shouldPrintOnlyNumbers() {
        PrintNumbersOnly.printOnlyNumbers(exampleArrayOfArrays);

        Assertions.assertTrue(outContent.toString().contains("1"));
        Assertions.assertTrue(outContent.toString().contains("12"));
        Assertions.assertTrue(outContent.toString().contains("22"));
        Assertions.assertTrue(outContent.toString().contains("28"));
    }


}
