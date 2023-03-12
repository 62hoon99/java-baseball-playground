package baseball;

import baseball.domain.Ball;
import baseball.domain.BaseBallStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallTest {

    private Ball ball;

    @BeforeEach
    public void set() {
        ball = new Ball(3, 1);
    }

    @Test
    public void 볼() throws Exception {
        //then
        Assertions.assertThat(ball.result(new Ball(3, 2))).isEqualTo(BaseBallStatus.BALL);
    }

    @Test
    public void 스트라이크() throws Exception {
        //then
        Assertions.assertThat(ball.result(new Ball(3, 1))).isEqualTo(BaseBallStatus.STRIKE);
    }

    @Test
    public void 낫싱() throws Exception {
        //then
        Assertions.assertThat(ball.result(new Ball(1, 2))).isEqualTo(BaseBallStatus.NOTHING);
    }
}
