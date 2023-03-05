package baseball.model.entity;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class AnswerNumber {

    private final String answerNumber;

    public AnswerNumber() {
        this.answerNumber = generateRandomNumber();
    }

    private String generateRandomNumber() {
        Set<Integer> randomNumbers = getRandomNumberSet(1, 11 ,3);

        return randomNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    private Set<Integer> getRandomNumberSet(int origin, int bound, int limit) {
        Random random = new Random();

        return random.ints(origin, bound)
                .distinct()
                .limit(limit)
                .boxed()
                .collect(Collectors.toSet());
    }
}
