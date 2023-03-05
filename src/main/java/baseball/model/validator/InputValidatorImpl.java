package baseball.model.validator;

import java.util.Arrays;

public class InputValidatorImpl implements InputValidator {

    private final String NATURAL_NUMBERS_MESSAGE = "각 자리는 자연수로만 이루어져야 합니다.";

    @Override
    public void validateNaturalNumbers(String input) {
        boolean result = Arrays.stream(splitInput(input))
                .mapToInt(this::inputToInteger)
                .allMatch(n -> n > 0);

        if (!result) {
            throw new IllegalArgumentException(NATURAL_NUMBERS_MESSAGE);
        }
    }

    private Integer inputToInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NATURAL_NUMBERS_MESSAGE);
        }
    }

    @Override
    public void validateDistinctNumbers(String input) {

    }

    @Override
    public void validateThreeDigitNumber(String input) {

    }

    private String[] splitInput(String input) {
        return input.split("");
    }
}
