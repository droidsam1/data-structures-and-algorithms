package exercise.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GreatestProductOfAnyThreeTest {


    @Test
    void shouldReturnTheGreatestProduct() {
        var input = new int[]{1, 2, 3};
        var expectedProduct = 6;

        var result = GreatestProductOfAnyThree.of(input);
        Assertions.assertEquals(expectedProduct, result);
    }

}
