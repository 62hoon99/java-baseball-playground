package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorUtilTest {

    @Test
    public void 숫자_1_9_검증() throws Exception {
        //then
        Assertions.assertThat(ValidatorUtil.validRange(1)).isTrue();
        Assertions.assertThat(ValidatorUtil.validRange(9)).isTrue();
        Assertions.assertThat(ValidatorUtil.validRange(0)).isFalse();
        Assertions.assertThat(ValidatorUtil.validRange(10)).isFalse();
    }
}
