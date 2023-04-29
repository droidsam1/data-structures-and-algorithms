package exercise.three;

public class GreatestNumberInArray {

    public static int in(int[] input) {
        return exponentialSearch(input);
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
    private static int exponentialSearch(int[] input) {

        for (int i = 0; i < input.length; i++) {
            var isTheGreatest = true;
            for (int j = i; j < input.length; j++) {
                if (input[i] < input[j]) {
                    isTheGreatest = false;
                    break;
                }
            }
            if(isTheGreatest){
                return input[i];
            }
        }
        return input[0];
    }
}
