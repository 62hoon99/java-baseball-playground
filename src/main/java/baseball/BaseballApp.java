package baseball;

import baseball.domain.Controller;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballApp {

    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new OutputView());
        controller.start();
    }
}
