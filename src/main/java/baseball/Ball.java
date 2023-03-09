package baseball;

import java.util.Objects;

public class Ball {
    private final Integer num;
    private final Integer idx;

    public Ball(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }

    public BaseBallStatus result(Ball ball) {
        if (this.equals(ball)) {
            return BaseBallStatus.STRIKE;
        }
        if (ball.match(num)) {
            return BaseBallStatus.BALL;
        }
        return BaseBallStatus.NOTHING;
    }

    private boolean match(Integer num) {
        return this.num.equals(num);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return num.equals(ball.num) && idx.equals(ball.idx);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, idx);
    }
}
