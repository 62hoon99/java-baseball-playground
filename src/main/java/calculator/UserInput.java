package calculator;

public class UserInput {

    private final String[] values;

    public UserInput(String values) {
        this.values = values.split(" ");
    }
}
