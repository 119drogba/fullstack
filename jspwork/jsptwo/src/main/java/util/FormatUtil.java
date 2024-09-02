package util;

import java.text.DecimalFormat;

public class FormatUtil {
    public static String number(long number, String pattern) {
        DecimalFormat format = new DecimalFormat(pattern);
        // DecimalFormat = 받은 숫자 값을 문자열로 바꿈
        return format.format(number);
    }

}
