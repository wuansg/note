package top.wuansg.note.util;

import top.wuansg.note.exception.AssertionException;

/**
 * @author wunansheng
 * @since 2021/6/3
 */
public class Assertions {

    public static <T> void assertEquals(T expire, T actual) {
        if (expire == null) {
            throw new AssertionException("expire value is null, consider use assertNull function");
        }
        if (!expire.equals(actual)) {
            throw new AssertionException(String.format("expire value is not equals to actual value, expireValue: %s, actualValue: %s", expire, actual));
        }
    }

}
