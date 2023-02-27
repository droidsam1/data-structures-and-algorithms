import intersection.Intersection;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IntersectionTest {

    private static final int[] EMPTY_ARRAY = new int[]{};

    private static Stream<Arguments> shouldReturnOneElementOnlyWhenArraysHaveSameElementButNotInOrder() {
        return Stream.of(
                //result, arr1, arr2
                Arguments.of(new int[]{2}, new int[]{1, 2}, new int[]{2}),//
                Arguments.of(new int[]{2}, new int[]{2}, new int[]{1, 2}),//
                Arguments.of(new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 2})//

        );
    }


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

    @ParameterizedTest @MethodSource void shouldReturnOneElementOnlyWhenArraysHaveSameElementButNotInOrder(
            int[] expected, int[] arr1, int[] arr2
    ) {
        var intersection = Intersection.of(arr1, arr2);

        Assertions.assertArrayEquals(expected, intersection);
    }


}