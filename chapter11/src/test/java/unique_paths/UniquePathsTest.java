package unique_paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UniquePathsTest {


    @ParameterizedTest
    @CsvSource(value = {"2,2,2", "3,3,6", "4,3,10", "3,7,28"})
    void shouldFindShortestPath(int rows, int cols, int expectedUniquePaths) {

        var result = UniquePaths.uniquePaths(rows, cols);

        Assertions.assertEquals(expectedUniquePaths, result);
    }

}
