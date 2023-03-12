package baseball.domain;

import java.util.List;
import java.util.stream.IntStream;

public class Baseball {

    private final Balls answerBalls;

    public Baseball(List<Integer> nums) {
        this.answerBalls = new Balls(nums);
    }

    public BaseballReport play(List<Integer> userNums) {
        BaseballReport report = new BaseballReport();

        IntStream
                .range(0, userNums.size())
                .mapToObj(i -> answerBalls.result(new Ball(userNums.get(i), i + 1)))
                .forEach(report::register);

        return report;
    }
}
