package baseball;

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
}
