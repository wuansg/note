package top.wuansg.note.leetcode;

import top.wuansg.note.util.Assertions;

import java.util.ArrayList;
import java.util.List;

public class Solution1239 {
    int max = 0;

    public static void main(String[] args) {
        Solution1239 solution1239 = new Solution1239();
        List<String> input = List.of("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p");
        Assertions.assertEquals(16, solution1239.maxLength(input));
        input = List.of("yy","bkhwmpbiisbldzknpm");
        Assertions.assertEquals(0, solution1239.maxLength(input));
        input = List.of("ab","cd","cde","cdef","efg","fgh","abxyz");
        Assertions.assertEquals(11, solution1239.maxLength(input));
    }

    public int maxLength(List<String> arr) {
        List<Integer> bit = new ArrayList<>(arr.size());
        for (String s : arr) {
            int i = 0;
            for (char c : s.toCharArray()) {
                int cToI = 1 << (c - 'a' + 1);
                if ((i & cToI) != 0) {
                    i = 0;
                    break;
                }
                i |= 1 << (c - 'a' + 1);
            }
            if (i != 0) {
                bit.add(i);
            }
        }
        max = 0;
        backtrace(bit, 0, 0);
        return max;
    }

    public void backtrace(List<Integer> bit, int index, int cur) {
        if (index >= bit.size()) {
            max = Math.max(BitCount(cur), max);
            return;
        }

        for (int i = index; i < bit.size(); i++) {
            int b = bit.get(i);
            if ((cur & b) == 0) {
                cur |= b;
                backtrace(bit, i+1, cur);
                cur ^= b;
            }
            backtrace(bit, i + 1, cur);
        }
    }

    private int BitCount(int i) {
        i = i - ((i >> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >> 2) & 0x33333333);
        i = (i + (i >> 4)) & 0x0f0f0f0f;
        i = i + (i >> 8);
        i = i + (i >> 16);
        return i & 0x3f;
    }
}
