package top.wuansg.note.util;

import top.wuansg.note.exception.AssertionException;
import top.wuansg.note.leetcode.structure.ListNode;

import java.util.Arrays;

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

    public static void assertNotNull(Object o) {
        if (o == null) {
            throw new AssertionException("expire object is null");
        }
    }

    public static void assertNotEmpty(int[] actual) {
        if (actual == null) {
            throw new AssertionException("actual object is null");
        }
        if (actual.length <= 0) {
            throw new AssertionException("actual object's length is 0");
        }
    }

    public static void assertEquals(int[] expire, ListNode actual) {
        if ((expire == null || expire.length <= 0) && actual == null) return;
        if (actual == null) {
            throw new AssertionException("actual value is not equals to expire, actual value: null, expire value is " + StringUtils.trans2String(expire));
        }
        if (expire == null || expire.length <= 0) {
            throw new AssertionException("actual value is not null but expire value is null");
        }
        int[] actualArray = ArrayUtils.trans2IntArray(actual);
        if (!Arrays.equals(expire, actualArray)) {
            throw new AssertionException("actual value is not equals to expire value, actual value is " + StringUtils.trans2String(actualArray)
                    + ", expire value is " + StringUtils.trans2String(expire));
        }
    }
}
