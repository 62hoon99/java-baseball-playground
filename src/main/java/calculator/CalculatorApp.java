package calculator;

public class CalculatorApp {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(new View());
        calculator.start();
    }
}
