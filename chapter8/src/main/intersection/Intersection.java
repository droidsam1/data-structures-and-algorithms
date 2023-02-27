package intersection;

public class Intersection {

    private Intersection() {

    }

    public static int[] of(int[] arr1, int[] arr2) {
        if (arr2[0] == arr1[0]) {
            return new int[]{arr1[0]};
        }

        return new int[]{};
    }
}
