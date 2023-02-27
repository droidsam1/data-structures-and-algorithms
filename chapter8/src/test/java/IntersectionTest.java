import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import intersection.Intersection;
import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class IntersectionTest {

    private static final int[] EMPTY_ARRAY = new int[]{};

    private static Stream<Arguments> shouldReturnIntersection() {
        return Stream.of(
                //result, arr1, arr2
                Arguments.of(new int[]{2}, new int[]{1, 2}, new int[]{2}),//
                Arguments.of(new int[]{2}, new int[]{2}, new int[]{1, 2}),//
                Arguments.of(new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 2}), //
                Arguments.of(EMPTY_ARRAY, new int[]{2}, new int[]{1}),//
                Arguments.of(new int[]{1}, new int[]{2, 1}, new int[]{1}), //
                Arguments.of(
                        new int[]{1, 3, 4, 10, 5, 9},
                        new int[]{2, 1, 3, 4, 10, 5, 9},
                        new int[]{9, 10, 3, 4, 5, 8, 12, 1}
                )//

        );
    }

    @ParameterizedTest @MethodSource void shouldReturnIntersection(
            int[] expected, int[] arr1, int[] arr2
    ) {
        var intersection = Intersection.of(arr1, arr2);

        assertArrayEquals(Arrays.stream(expected).sorted().toArray(), Arrays.stream(intersection).sorted().toArray());
    }

}