package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("replace test")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("split test")
    public void split() throws Exception {
        //given
        String actual = "1,2";

        //when
        String[] split = actual.split(",");

        //then
        assertThat(split).contains("1", "2");
    }

    @Test
    @DisplayName("split test")
    public void split2() throws Exception {
        //given
        String actual = "1";

        //when
        String[] split = actual.split(",");

        //then
        assertThat(split).containsExactly("1");
    }

    @Test
    @DisplayName("substring test")
    public void substring() throws Exception {
        //given
        String actual = "(1,2)";

        //when
        String substring = actual.substring(1, 4);

        //then
        assertThat(substring).isEqualTo("1,2");
    }

    @Test
    @DisplayName("charAt test")
    public void charAt() throws Exception {
        //given
        String actual = "abc";

        //when
        char b = actual.charAt(1);

        //then
        assertThat(b).isEqualTo('b');
    }

    @Test
    @DisplayName("charAt exception test")
    public void exception() throws Exception {
        //given
        String actual = "abc";

        //when

        //then
        assertThatThrownBy(() -> actual.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class);
    }

}
