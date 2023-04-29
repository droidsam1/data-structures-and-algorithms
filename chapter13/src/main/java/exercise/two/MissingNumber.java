package exercise.two;

public class MissingNumber {

    private MissingNumber() {
    }

    public static Integer in(int[] input) {
        var sortedInput = sort(input);
        for (int i = 0; i < sortedInput.length; i++) {
            if (sortedInput[i] != i) {
                return i;
            }
        }
        return null;
    }

    private static int[] sort(int[] input) {
        var aCopy = input.clone();
        quickSort(aCopy, 0, aCopy.length-1);
        return aCopy;
    }

    private static void quickSort(int[] input, int fromIndex, int toIndex) {
        if (fromIndex >= toIndex) {
            return;
        }
        var swapIndex = fromIndex;
        for (int currentIndex = fromIndex; currentIndex < toIndex; currentIndex++) {
            if (input[currentIndex] < input[toIndex]) {
                if (currentIndex > swapIndex) {
                    //swap
                    var temp = input[swapIndex];
                    input[swapIndex] = input[currentIndex];
                    input[currentIndex] = temp;
                }
                swapIndex++;
            }
        }

        //swap
        var temp = input[swapIndex];
        input[swapIndex] = input[toIndex];
        input[toIndex] = temp;

        quickSort(input, fromIndex, swapIndex -1);
        quickSort(input, swapIndex, toIndex);
    }

}
