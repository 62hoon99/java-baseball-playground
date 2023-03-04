package calculator;

import java.util.Scanner;

public class View {

    private final Scanner scanner;

    public String inputView() {
        return scanner.nextLine();
    }

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void outputView(String value) {
        System.out.println(value);
    }
}
