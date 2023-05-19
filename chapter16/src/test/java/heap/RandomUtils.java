package heap;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class RandomUtils {

    public static Integer[] generateRandomInput() {
        return IntStream.generate(() -> ThreadLocalRandom.current().nextInt())
                        .limit(1000)
                        .boxed()
                        .toArray((Integer[]::new));
    }

}
