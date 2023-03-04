package calculator;

import java.util.Arrays;

public class UserInput {

    private final String[] values;

    public UserInput(String value) {
        String[] inputValues = value.split(" ");
        validateFirstValueNonNumeric(inputValues);
        validateInvalidCharacter(inputValues);
        validateDivideZero(inputValues);
        validateAlternatingCharacters(inputValues);
        validateLastValueNonNumeric(inputValues);
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

    private void validateFirstValueNonNumeric(String[] inputValues) {
        try {
            Integer.parseInt(inputValues[0]);
        } catch (Exception e) {
            throw new IllegalArgumentException("첫 글자는 숫자만 가능합니다.");
        }
    }

    private void validateInvalidCharacter(String[] inputValues) {
        boolean match = Arrays.stream(inputValues)
                .noneMatch(this::hasInvalidCharacter);

        if (!match) {
            throw new IllegalArgumentException("숫자와 연산 문자로만 이루어져야 합니다.");
        }
    }

    private boolean hasInvalidCharacter(String s) {
        // 잘못함
        if (!isOperator(s)) {
            return false;
        }

        if (!isDigit(s)) {
            return false;
        }

        return true;
    }

    private void validateDivideZero(String[] inputValues) {
        for (int i = 0; i < inputValues.length - 1; i++) {
            checkDividedZero(inputValues[i], inputValues[i + 1]);
        }
    }

    private void checkDividedZero(String front, String back) {
        if (front.equals("/") && back.equals("0")) {
            throw new IllegalArgumentException("0으로 나누기는 불가능 합니다.");
        }
    }

    private void validateAlternatingCharacters(String[] inputValues) {
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

    private void validateLastValueNonNumeric(String[] inputValues) {
        try {
            Integer.parseInt(inputValues[inputValues.length - 1]);
        } catch (Exception e) {
            throw new IllegalArgumentException("마지막 글자는 숫자만 가능합니다.");
        }
    }
}
