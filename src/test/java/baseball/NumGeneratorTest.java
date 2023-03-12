package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class NumGeneratorTest {

    @Test
    public void 랜덤_숫자_생성() throws Exception {
        //when
        List<Integer> numbers = NumGenerator.generate();
        //then
        Assertions.assertThat(ValidatorUtil.validDupli(numbers)).isTrue();
        Assertions.assertThat(numbers.size()).isEqualTo(3);
        for (Integer number : numbers) {
            Assertions.assertThat(ValidatorUtil.validRange(number)).isTrue();
        }
    }
}
