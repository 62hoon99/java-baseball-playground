package calculator.userInput.userInputValidator;

import java.util.Arrays;

public class UserInputValidatorImpl implements UserInputValidator {

    @Override
    public void validateFirstValueNonNumeric(String[] inputValues) {
        try {
            Integer.parseInt(inputValues[0]);
        } catch (Exception e) {
            throw new IllegalArgumentException("첫 글자는 숫자만 가능합니다.");
        }
    }

    @Override
    public void validateInvalidCharacter(String[] inputValues) {
        boolean match = Arrays.stream(inputValues)
                .noneMatch(this::hasInvalidCharacter);

        if (!match) {
            throw new IllegalArgumentException("숫자와 연산 문자로만 이루어져야 합니다.");
        }
    }

    private boolean hasInvalidCharacter(String s) {
        if (!isOperator(s) && !isDigit(s)) {
            return true;
        }
        return false;
    }

    @Override
    public void validateDivideZero(String[] inputValues) {
        for (int i = 0; i < inputValues.length - 1; i++) {
            checkDividedZero(inputValues[i], inputValues[i + 1]);
        }
    }

    private void checkDividedZero(String front, String back) {
        if (front.equals("/") && back.equals("0")) {
            throw new IllegalArgumentException("0으로 나누기는 불가능 합니다.");
        }
    }

    @Override
    public void validateAlternatingCharacters(String[] inputValues) {
        for (int i = 0; i < inputValues.length - 1; i++) {
            checkAlternatingCharacters(inputValues[i], inputValues[i + 1]);
        }
    }

    private void checkAlternatingCharacters(String front, String back) {
        if (isOperator(front) && isOperator(back)) {
            throw new IllegalArgumentException("연산자는 연속으로 올 수 없습니다.");
        }

        if (isDigit(front) && isDigit(back)) {
            throw new IllegalArgumentException("숫자는 연속으로 올 수 없습니다.");
        }
    }

    private boolean isOperator(String operator) {
        if (operator.equals("+") || operator.equals("-") || operator.equals("/") || operator.equals("*")) {
            return true;
        }
        return false;
    }

    private boolean isDigit(String digit) {
        try {
            Integer.parseInt(digit);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void validateLastValueNonNumeric(String[] inputValues) {
        try {
            Integer.parseInt(inputValues[inputValues.length - 1]);
        } catch (Exception e) {
            throw new IllegalArgumentException("마지막 글자는 숫자만 가능합니다.");
        }
    }
}
