package top.wuansg.note.util;

import top.wuansg.note.exception.AssertionException;
import top.wuansg.note.leetcode.structure.ListNode;

import java.util.Arrays;

/**
 * @author wunansheng
 * @since 2021/6/3
 */
public class Assertions {

    public static void assertTrue(boolean actual) {
        if (!actual) {
            throw new AssertionException("actual value is false");
        }
    }

    public static void assertFalse(boolean actual) {
        if (actual) {
            throw new AssertionException("actual value is true");
        }
    }

    public static <T> void assertEquals(T expire, T actual) {
        if (expire == null) {
            throw new AssertionException("expire value is null, consider use assertNull function");
        }
        if (expire instanceof int[]) {
            if (!(actual instanceof int[])) throw new AssertionException("expire type is not same as actual type");
            int[] expireInts = (int[]) expire;
            int[] actualInts = (int[]) actual;
            if (expireInts.length != actualInts.length) throw new AssertionException(String.format("expire length is not equals to actual value, expire length: %s, actual length: %s", expireInts.length, actualInts.length));
            for (int i = 0; i < expireInts.length; i++) {
                if (expireInts[i] != actualInts[i]) {
                    throw new AssertionException(String.format("index: %s of array value is not equals, actual value: %s, expire value: %s", i, Arrays.toString(actualInts), Arrays.toString(expireInts)));
                }
            }
            return;
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
