package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputValidator {

    public static List<Integer> validInput(String input) {
        validLength(input);
        validNum(input);
        List<Integer> nums = map(input);
        validRange(nums);
        validDupli(nums);
        return nums;
    }

    private static void validLength(String input) {
        if (!ValidatorUtil.validLength(input)) {
            throw new IllegalArgumentException("길이는 3이어야 합니다.");
        }
    }

    private static void validNum(String input) {
        if (!ValidatorUtil.validNum(input)) {
            throw new IllegalArgumentException("숫자만 가능합니다.");
        }
    }

    private static List<Integer> map(String input) {
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void validRange(List<Integer> nums) {
        if (nums.stream().anyMatch(num -> !ValidatorUtil.validRange(num))) {
            throw new IllegalArgumentException("1~9 사이의 숫자만 가능합니다.");
        }
    }

    private static void validDupli(List<Integer> nums) {
        if (!ValidatorUtil.validDupli(nums)) {
            throw new IllegalArgumentException("중복은 불가능합니다.");
        }
    }
}
