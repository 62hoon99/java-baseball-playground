package calculator;

import calculator.userInput.UserInput;
import calculator.userInput.userInputValidator.UserInputValidator;
import calculator.userInput.userInputValidator.UserInputValidatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class UserInputTest {

    private UserInputValidator userInputValidator;

    @BeforeEach
    public void setUp() {
        userInputValidator = new UserInputValidatorImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a + 1", "+ 1"})
    @DisplayName("입력값 첫 글자 검증 기능")
    public void validateFirstValueNonNumeric(String inputValue) throws Exception {
        assertThatThrownBy(() -> userInputValidator.validateFirstValueNonNumeric(splitValue(inputValue)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("첫 글자는 숫자만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a + 1", "1 a 1"})
    @DisplayName("입력값 구성 검증 기능")
    public void validateInvalidCharacter(String inputValue) throws Exception {
        assertThatThrownBy(() -> userInputValidator.validateInvalidCharacter(splitValue(inputValue)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자와 연산 문자로만 이루어져야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 / 0"})
    @DisplayName("입력값이 0으로 나누어지는지 검증 기능")
    public void validateDivideZero(String inputValue) throws Exception {
        assertThatThrownBy(() -> userInputValidator.validateDivideZero(splitValue(inputValue)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나누기는 불가능 합니다.");
    }

    private String[] splitValue(String value) {
        return value.split(" ");
    }

}