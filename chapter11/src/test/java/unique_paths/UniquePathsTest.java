package unique_paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UniquePathsTest {


    @Test
    void shouldFindShortestPath() {
        var inputRows = 2;
        var inputCols = 2;

        var result = UniquePaths.uniquePaths(inputRows, inputCols);

        Assertions.assertEquals(2, result);

    }

}
