package calculator;

public class Calculator {

    private final View view;

    public Calculator(View view) {
        this.view = view;
    }

    public void start() {
        String value = view.inputView();
    }
}
