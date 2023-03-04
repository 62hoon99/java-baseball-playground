package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class UserInputTest {

    @ParameterizedTest
    @ValueSource(strings = {"a + 1", "+ 1"})
    @DisplayName("입력값 첫 글자 검증 기능")
    public void validateFirstValueNonNumeric(String inputValue) throws Exception {
        assertThatThrownBy(() -> new UserInput(inputValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("첫 글자는 숫자만 가능합니다.");
    }

}