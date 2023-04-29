package exercise.three;

public class GreatestNumberInArray {

    public static int in(int[] input) {
        return sequentialSearch(input);
    }

    private static int sequentialSearch(int[] input) {

        int greatest = 0;
        for (int n : input) {
            if (n > greatest) {
                greatest = n;
            }
        }
        return greatest;

    }
}
