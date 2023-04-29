package exercise.three;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GreatestNumberInArrayTest {


    @Test
    void shouldReturnTheGreatestNumberInArray() {
        var input = generateARandomArray();
        var expectedGreatestNumber = IntStream.of(input).max().orElseThrow();

        var result = GreatestNumberInArray.in(input);
        Assertions.assertEquals(expectedGreatestNumber, result);
    }

    private static int[] generateARandomArray(){
        return IntStream.generate(()->new Random().nextInt(100)).limit(100).toArray();
    }
}
