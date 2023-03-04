package calculator;

import calculator.userInput.UserInput;
import calculator.userInput.userInputValidator.UserInputValidator;
import calculator.userInput.userInputValidator.UserInputValidatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
    public void validateFirstValueNonNumeric(String inputValue) {
        assertThatThrownBy(() -> userInputValidator.validateFirstValueNonNumeric(splitValue(inputValue)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("첫 글자는 숫자만 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a + 1", "1 a 1"})
    @DisplayName("입력값 구성 검증 기능")
    public void validateInvalidCharacter(String inputValue) {
        assertThatThrownBy(() -> userInputValidator.validateInvalidCharacter(splitValue(inputValue)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자와 연산 문자로만 이루어져야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 / 0"})
    @DisplayName("입력값이 0으로 나누어지는지 검증 기능")
    public void validateDivideZero(String inputValue) {
        assertThatThrownBy(() -> userInputValidator.validateDivideZero(splitValue(inputValue)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나누기는 불가능 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + / 3", " 1 * 3 + + 4"})
    @DisplayName("연산자가 연속해서 나오는 경우 검증 기능")
    public void validateContinueOperators(String inputValue) {
        assertThatThrownBy(() -> userInputValidator.validateAlternatingCharacters(splitValue(inputValue)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("연산자는 연속으로 올 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 1 + 1", "2 + 3 4"})
    @DisplayName("숫자가 연속해서 나오는 경우 검증 기능")
    public void validateContinueNumbers(String inputValue) {
        assertThatThrownBy(() -> userInputValidator.validateAlternatingCharacters(splitValue(inputValue)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자는 연속으로 올 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + 3 /", "2 + 3 +"})
    @DisplayName("마지막 글자가 숫자인 경우 검증 기능")
    public void validateLastValueNonNumeric(String inputValue) {
        assertThatThrownBy(() -> userInputValidator.validateLastValueNonNumeric(splitValue(inputValue)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("마지막 글자는 숫자만 가능합니다.");
    }

    @Test
    @DisplayName("정상 동작 확인")
    public void normalOperation() {
        //given
        UserInput userInput = new UserInput("2 + 3 * 4 / 2");
        //when

        //then
        assertThat(userInput.calculate()).isEqualTo(10);
    }

    private String[] splitValue(String value) {
        return value.split(" ");
    }

}