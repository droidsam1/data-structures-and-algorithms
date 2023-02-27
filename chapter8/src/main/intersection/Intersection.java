package intersection;

import java.util.ArrayList;
import java.util.HashMap;

public class Intersection {

    private Intersection() {

    }

    public static int[] of(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return new int[]{};
        }

        var hashMap = new HashMap<>();

        var result = new ArrayList<Integer>();

        for (int elementInArr1 : arr1) {
            hashMap.put(elementInArr1, false);
        }
        for (int elementInArr2 : arr2) {
            if (hashMap.get(elementInArr2) != null) {
                result.add(elementInArr2);
            }

        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
