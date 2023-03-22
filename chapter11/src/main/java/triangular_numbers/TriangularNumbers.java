package triangular_numbers;

public class TriangularNumbers {

    private TriangularNumbers() {
    }

    public static int getNth(int input) {
        if (input <= 0) {
            return 0;
        }
        return input + getNth(input - 1);
    }
}
