package baseball;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class NumGenerator {
    public static List<Integer> generate() {
        return new Random().ints(1, 10)
                .distinct()
                .limit(3)
                .boxed()
                .collect(Collectors.toList());
    }
}
