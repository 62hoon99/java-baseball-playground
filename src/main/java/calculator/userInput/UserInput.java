package calculator.userInput;

import calculator.userInput.userInputValidator.UserInputValidator;
import calculator.userInput.userInputValidator.UserInputValidatorImpl;

public class UserInput {

    private final String[] values;

    private final UserInputValidator userInputValidator;

    public UserInput(String value) {
        userInputValidator = new UserInputValidatorImpl();

        String[] inputValues = value.split(" ");
        userInputValidator.validateFirstValueNonNumeric(inputValues);
        userInputValidator.validateInvalidCharacter(inputValues);
        userInputValidator.validateDivideZero(inputValues);
        userInputValidator.validateAlternatingCharacters(inputValues);
        userInputValidator.validateLastValueNonNumeric(inputValues);
        this.values = inputValues;
    }

    public Integer calculate() {
        Integer preNumber = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            preNumber = calculate(preNumber, values[i], Integer.parseInt(values[i + 1]));
        }
        return preNumber;
    }

    private Integer calculate(Integer preNumber, String operator, Integer postNumber) {
        if (operator.equals("+")) {
            return preNumber + postNumber;
        }
        if (operator.equals("-")) {
            return preNumber - postNumber;
        }
        if (operator.equals("/")) {
            return preNumber / postNumber;
        }
        return preNumber * postNumber;
    }

}
