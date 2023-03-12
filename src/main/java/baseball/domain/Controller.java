package baseball.domain;

import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Controller {

    private final InputView inputView;

    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        Baseball baseball = new Baseball(NumGenerator.generate());
        play(baseball);
    }

    private void play(Baseball baseball) {
        try {
            List<Integer> userNums = InputValidator.validInput(inputView.number());
            BaseballReport report = baseball.play(userNums);
            outputView.result(report);
            end(baseball, report);
        } catch (IllegalArgumentException e) {
            outputView.exception(e.getMessage());
            play(baseball);
        }
    }

    private void end(Baseball baseball, BaseballReport report) {
        if (report.isEnd()) {
            outputView.complete();
            retry();
        }
        if (!report.isEnd()) {
            play(baseball);
        }
    }

    private void retry() {
        if (inputView.retry().equals("1")) {
            start();
        }
    }
}
