package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidatorUtil {

    public static boolean validRange(int num) {
        return num > 0 && num < 10;
    }

    public static boolean validNum(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validLength(String s) {
        return s.length() == 3;
    }

    public static boolean validDupli(List<Integer> nums) {
        Set<Integer> set = new HashSet<>(nums);
        return set.size() == nums.size();
    }
}
