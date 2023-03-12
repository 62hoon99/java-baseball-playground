package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BallsTest {

    private Balls balls;

    @BeforeEach
    public void set() {
        balls = new Balls(Arrays.asList(new Ball(1, 1), new Ball(2, 2), new Ball(3, 3)));
    }

    @Test
    public void 낫싱() throws Exception {
        //then
        Assertions.assertThat(balls.result(new Ball(4, 1))).isEqualTo(BaseBallStatus.NOTHING);
    }

    @Test
    public void 스트라이크() throws Exception {
        //then
        Assertions.assertThat(balls.result(new Ball(1, 1))).isEqualTo(BaseBallStatus.STRIKE);
    }

    @Test
    public void 볼() throws Exception {
        //then
        Assertions.assertThat(balls.result(new Ball(1, 3))).isEqualTo(BaseBallStatus.BALL);
    }
}
