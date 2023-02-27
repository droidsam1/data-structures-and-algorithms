package intersection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Intersection {

    private Intersection() {

    }

    public static int[] of(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return new int[]{};
        }

        List<Integer> result = new ArrayList<>();

        for (int elementInArr1 : arr1) {
            for (int elementInArr2 : arr2) {
                if (elementInArr1 == elementInArr2) {
                    result.add(elementInArr1);
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
