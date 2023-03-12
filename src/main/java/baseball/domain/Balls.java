package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Integer> nums) {
        this.balls = mapBalls(nums);
    }

    private List<Ball> mapBalls(List<Integer> nums) {
        List<Ball> newBalls = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            newBalls.add(new Ball(nums.get(i), i + 1));
        }
        return newBalls;
    }

    public BaseBallStatus result(Ball ball) {
        return balls.stream()
                .map(b -> b.result(ball))
                .filter(status -> !status.match(BaseBallStatus.NOTHING))
                .findAny()
                .orElse(BaseBallStatus.NOTHING);
    }
}
