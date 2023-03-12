package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static baseball.ValidatorUtil.*;
import static org.assertj.core.api.Assertions.*;

public class ValidatorUtilTest {

    @Test
    public void 숫자_1_9_검증() throws Exception {
        //then
        assertThat(validRange(1)).isTrue();
        assertThat(validRange(9)).isTrue();
        assertThat(validRange(0)).isFalse();
        assertThat(validRange(10)).isFalse();
    }

    @Test
    public void 숫자인지_검증() throws Exception {
        //then
        assertThat(validNum("123")).isTrue();
        assertThat(validNum("a12")).isFalse();
    }

    @Test
    public void 자리수_3_검증() throws Exception {
        //then
        assertThat(validLength("123")).isTrue();
        assertThat(validLength("1245")).isFalse();
    }

    @Test
    public void 중복_검증() throws Exception {
        //then
        assertThat(validDupli(Arrays.asList(1, 2, 3))).isTrue();
        assertThat(validDupli(Arrays.asList(1, 1, 4))).isFalse();
    }
}
