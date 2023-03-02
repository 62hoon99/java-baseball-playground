package calculator;

import java.util.Arrays;

public class UserInput {

    private final String[] values;

    public UserInput(String value) {
        String[] inputValues = value.split(" ");
        validateFirstValueNonNumeric(inputValues);
        validateInvalidCharacter(inputValues);
        validateDivideZero(inputValues);
        this.values = inputValues;
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
        if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
            return false;
        }

        try {
            Integer.parseInt(s);
            return false;
        } catch (Exception e) {
            return true;
        }
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
}
