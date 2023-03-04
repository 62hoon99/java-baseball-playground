package calculator;

import calculator.userInput.UserInput;

public class Calculator {

    private final View view;

    public Calculator(View view) {
        this.view = view;
    }

    public void start() {

        try {
            UserInput userInput = new UserInput(view.inputView());
            Integer result = userInput.calculate();
            view.outputView(Integer.toString(result));

        } catch (IllegalArgumentException e) {
            view.outputView(e.getMessage());
        }
    }
}
