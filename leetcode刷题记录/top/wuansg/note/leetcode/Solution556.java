package top.wuansg.note.leetcode;

//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
//
// 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：n = 12
//输出：21
//
//
// 示例 2：
//
//
//输入：n = 21
//输出：-1
//
//
//
//
// 提示：
//
//
// 1 <= n <= 2³¹ - 1
//
public class Solution556 {

    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int i = chars.length - 2;
        while (i >= 0 && chars[i] >= chars[i+1]) i--;
        if (i < 0) return -1;
        int j = chars.length - 2;
        while (j >= 0 && chars[i] >= chars[j]) j--;
        swap(chars, i, j);
        reverse(chars, i+1);
        long l = Long.parseLong(new String(chars));
        return l > Integer.MAX_VALUE ? -1 : (int) l;
    }

    private void swap(char[] chars, int i, int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    private void reverse(char[] chars, int start) {
        int end = chars.length - 1;
        while (start < end) {
            swap(chars, start, end);
            start++;
            end--;
        }
    }
}
