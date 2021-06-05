package top.wuansg.note.util;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringUtils {

    public static String trans2String(int[] intArray) {
        return Arrays.stream(intArray).mapToObj(String::valueOf).collect(Collectors.joining());
    }
}
