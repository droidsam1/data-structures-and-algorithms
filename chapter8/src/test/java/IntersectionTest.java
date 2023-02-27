import intersection.Intersection;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntersectionTest {

    private static final int[] EMPTY_ARRAY = new int[]{};


    @Test void shouldReturnAnEmptyArrayWhenNotIntersection() {
        var arr1 = new int[]{1};
        var arr2 = new int[]{2};

        var intersection = Intersection.of(arr1, arr2);

        Assertions.assertArrayEquals(EMPTY_ARRAY, intersection);
    }

    @Test void shouldReturnOneElementOnlyWhenArraysHaveSameElement() {
        var arr1 = new int[]{1};
        var arr2 = new int[]{1};

        var intersection = Intersection.of(arr1, arr2);

        Assertions.assertArrayEquals(new int[]{1}, intersection);
    }

}