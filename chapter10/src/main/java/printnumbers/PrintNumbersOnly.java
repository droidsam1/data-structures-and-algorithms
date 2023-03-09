package printnumbers;

public class PrintNumbersOnly {

    private PrintNumbersOnly() {
    }

    public static void printOnlyNumbers(Object input) {
        if (input instanceof Number) {
            System.out.println(input); //NOSONAR
            return;
        }
        if (input instanceof Object[]) {
            for (var o : (Object[]) input) {
                printOnlyNumbers(o);
            }
        }
    }
}
