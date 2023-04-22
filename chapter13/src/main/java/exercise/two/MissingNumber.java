package exercise.two;

public class MissingNumber {

    public static Integer in(int[] input) {

        for (int i = 0; i < input.length; i++) {
            if (input[i] != i) {
                return i;
            }
        }
        return null;
    }
}
