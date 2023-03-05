package baseball.model.validator;

public class InputValidatorImpl implements InputValidator {

    private final String NUMERIC_ONLY_MESSAGE = "입력값은 숫자로만 이루어져야 합니다.";

    @Override
    public void validateNumericOnly(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMERIC_ONLY_MESSAGE);
        }
    }

    @Override
    public void validateNaturalNumbers(String input) {

    }

    @Override
    public void validateDistinctNumbers(String input) {

    }

    @Override
    public void validateThreeDigitNumber(String input) {

    }
}
