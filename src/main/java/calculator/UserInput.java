package calculator;

public class UserInput {

    private final String[] values;

    public UserInput(String value) {
        String[] inputValues = value.split(" ");
        validateFirstValueNonNumeric(inputValues);
        this.values = inputValues;
    }

    private void validateFirstValueNonNumeric(String[] inputValues) {
        try {
            Integer.parseInt(inputValues[0]);
        } catch (Exception e) {
            throw new IllegalArgumentException("첫 글자는 숫자만 가능합니다.");
        }
    }
}
