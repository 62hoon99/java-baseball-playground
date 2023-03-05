package baseball.model.validator;

public interface InputValidator {

    void validateNaturalNumbers(String input);

    void validateDistinctNumbers(String input);

    void validateThreeDigitNumber(String input);
}
