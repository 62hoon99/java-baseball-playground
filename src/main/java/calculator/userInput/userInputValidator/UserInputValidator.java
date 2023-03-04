package calculator.userInput.userInputValidator;

public interface UserInputValidator {

    void validateFirstValueNonNumeric(String[] inputValues);

    void validateInvalidCharacter(String[] inputValues);

    void validateDivideZero(String[] inputValues);

    void validateAlternatingCharacters(String[] inputValues);

    void validateLastValueNonNumeric(String[] inputValues);
}
