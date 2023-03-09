package printnumbers;

import java.util.Arrays;

public class PrintNumbersOnly {

    private PrintNumbersOnly() {
    }

    public static void printOnlyNumbers(Object[] input) {
        System.out.println(Arrays.toString(input)); //NOSONAR
    }
}
