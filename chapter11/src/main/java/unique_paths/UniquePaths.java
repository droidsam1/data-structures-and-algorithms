package unique_paths;

public class UniquePaths {

    private UniquePaths() {
    }

    public static int uniquePaths(int inputRows, int inputCols) {
        if (inputRows == 1 || inputCols == 1) {
            return 1;
        }
        return uniquePaths(inputRows - 1, inputCols) + uniquePaths(inputRows, inputCols - 1);

    }
}
