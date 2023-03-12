package baseball.domain;

public class BaseballReport {

    private Integer strike;

    private Integer ball;

    public BaseballReport() {
        this.strike = 0;
        this.ball = 0;
    }

    public void register(BaseBallStatus status) {
        if (status.match(BaseBallStatus.STRIKE)) {
            strike++;
        }
        if (status.match(BaseBallStatus.BALL)) {
            ball++;
        }
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isEnd() {
        return strike == 3;
    }
}
