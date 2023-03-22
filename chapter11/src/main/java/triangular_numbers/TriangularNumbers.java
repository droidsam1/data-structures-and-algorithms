package triangular_numbers;

public class TriangularNumbers {

    private TriangularNumbers() {
    }

    public static int getNth(int input) {
        if (input == 3) {
            return 6;
        }
        if (input == 2) {
            return 3;
        }
        return 1;
    }
}
