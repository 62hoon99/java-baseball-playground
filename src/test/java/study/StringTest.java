package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    public void split() throws Exception {
        //given
        String actual = "1,2";

        //when
        String[] split = actual.split(",");

        //then
        assertThat(split).contains("1", "2");
    }

    @Test
    public void split2() throws Exception {
        //given
        String actual = "1";

        //when
        String[] split = actual.split(",");

        //then
        assertThat(split).containsExactly("1");
    }
}
