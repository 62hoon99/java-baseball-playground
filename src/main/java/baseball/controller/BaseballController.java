package baseball.controller;

import baseball.model.dto.BaseballGameResultDto;
import baseball.model.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballController {

    private final InputView inputView;

    private final OutputView outputView;

    private final BaseballService baseballService;

    public BaseballController(InputView inputView, OutputView outputView, BaseballService baseballService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.baseballService = baseballService;
    }

    public void start() {
        while (true) {
            try {
                String numbers = inputView.number();
                baseballService.validateInputValue(numbers);
                BaseballGameResultDto gameResult = baseballService.getGameResult(numbers);
                outputView.result(gameResult);

                if (gameResult.getComplete()) {
                    outputView.complete();
                    break;
                }
            } catch (IllegalArgumentException e) {
                outputView.exception(e.getMessage());
            }
        }
    }
}
