package exercise.one;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GreatestProductOfAnyThreeTest {


    @Test
    void shouldReturnTheGreatestProductForInputsOfSizeThree() {
        var input = new int[]{1, 2, 3};
        var expectedProduct = 6;

        var result = GreatestProductOfAnyThree.of(input);
        Assertions.assertEquals(expectedProduct, result);
    }

    @Test
    void shouldReturnTheGreatestProductOfAscendingOrderInputs() {
        var input = new int[]{1, 2, 3, 4, 5, 6};
        var expectedProduct = 120;

        var result = GreatestProductOfAnyThree.of(input);
        Assertions.assertEquals(expectedProduct, result);
    }

    @Test
    void shouldReturnTheGreatestProductOfDescendingOrderInputs() {
        var input = new int[]{10, 9, 8, 7, 6 ,5, 1};
        var expectedProduct = 720;

        var result = GreatestProductOfAnyThree.of(input);
        Assertions.assertEquals(expectedProduct, result);
    }

}
