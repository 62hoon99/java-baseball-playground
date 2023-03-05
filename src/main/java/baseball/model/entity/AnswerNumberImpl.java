package baseball.model.entity;

import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AnswerNumberImpl implements AnswerNumber {

    private final String answerNumber;

    private final Integer limit = 3;

    public AnswerNumberImpl() {
        this.answerNumber = generateRandomNumber();
    }

    private String generateRandomNumber() {
        Set<Integer> randomNumbers = getRandomNumberSet(1, 11, limit);

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

    @Override
    public Integer countStrikes(String number) {
        String[] answerNumbers = splitInput(answerNumber);
        String[] numbers = splitInput(number);

        return (int) IntStream.range(0, limit)
                .filter(i -> answerNumbers[i].equals(numbers[i]))
                .count();
    }

    @Override
    public Integer countBalls(String number) {
        String[] answerNumbers = splitInput(answerNumber);
        String[] numbers = splitInput(number);

        return (int) IntStream.range(0, limit)
                .filter(i -> isBall(numbers[i], i, answerNumbers))
                .count();
    }

    private boolean isBall(String str, int index, String[] stringArr) {

        return IntStream.range(0, limit)
                .anyMatch(i -> i != index && stringArr[i].equals(str));
    }

    @Override
    public Boolean isNothing(String number) {
        return null;
    }

    private String[] splitInput(String input) {
        return input.split("");
    }
}
