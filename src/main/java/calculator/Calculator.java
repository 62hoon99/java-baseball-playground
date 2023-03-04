package calculator;

public class Calculator {

    private final View view;

    public Calculator(View view) {
        this.view = view;
    }

    public void start() {
        UserInput userInput = new UserInput(view.inputView());
        Integer result = userInput.calculate();
        view.outputView(Integer.toString(result));
    }
}
