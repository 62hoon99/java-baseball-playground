package baseball;

import baseball.domain.Baseball;
import baseball.domain.BaseballReport;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BaseballTest {

    private Baseball baseball;

    @BeforeEach
    public void set() {
        this.baseball = new Baseball(Arrays.asList(1, 2 ,3));
    }

    @Test
    public void 스트라이크3_볼0() throws Exception {
        //when
        BaseballReport report = baseball.play(Arrays.asList(1, 2, 3));
        //then
        Assertions.assertThat(report.getStrike()).isEqualTo(3);
        Assertions.assertThat(report.getBall()).isEqualTo(0);
        Assertions.assertThat(report.isNothing()).isEqualTo(false);
        Assertions.assertThat(report.isEnd()).isEqualTo(true);
    }

    @Test
    public void 스트라이크1_볼2() throws Exception {
        //when
        BaseballReport report = baseball.play(Arrays.asList(1, 3, 2));
        //then
        Assertions.assertThat(report.getStrike()).isEqualTo(1);
        Assertions.assertThat(report.getBall()).isEqualTo(2);
        Assertions.assertThat(report.isNothing()).isEqualTo(false);
        Assertions.assertThat(report.isEnd()).isEqualTo(false);
    }

    @Test
    public void 낫싱() throws Exception {
        //when
        BaseballReport report = baseball.play(Arrays.asList(4, 5, 6));
        //then
        Assertions.assertThat(report.getStrike()).isEqualTo(0);
        Assertions.assertThat(report.getBall()).isEqualTo(0);
        Assertions.assertThat(report.isNothing()).isEqualTo(true);
        Assertions.assertThat(report.isEnd()).isEqualTo(false);
    }

}
