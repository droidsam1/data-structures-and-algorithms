package intersection;

public class Intersection {

    private Intersection() {

    }

    public static int[] of(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return new int[]{};
        }

        if (arr1[0] == arr2[0]) {
            return new int[]{arr1[0]};
        }
        if (arr2.length > 1 && arr1[0] == arr2[1]) {
            return new int[]{arr1[0]};
        }

        return new int[]{};
    }
}
