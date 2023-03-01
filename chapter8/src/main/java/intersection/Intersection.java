package intersection;

import java.util.HashMap;
import java.util.Map.Entry;

public class Intersection {

    private Intersection() {

    }

    public static int[] of(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return new int[]{};
        }

        var hashMap = new HashMap<Integer, Boolean>();

        for (int elementInArr1 : arr1) {
            hashMap.put(elementInArr1, false);
        }
        for (int elementInArr2 : arr2) {
            hashMap.computeIfPresent(elementInArr2, (o, o2) -> true);
        }

        return hashMap.entrySet().stream().filter(Entry::getValue).mapToInt(Entry::getKey).toArray();
    }

}
