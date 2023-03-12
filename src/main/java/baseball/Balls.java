package baseball;

import java.util.List;

public class Balls {

    private List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public BaseBallStatus result(Ball ball) {
        return balls.stream()
                .map(b -> b.result(ball))
                .filter(status -> !status.match(BaseBallStatus.NOTHING))
                .findAny()
                .orElse(BaseBallStatus.NOTHING);
    }
}
