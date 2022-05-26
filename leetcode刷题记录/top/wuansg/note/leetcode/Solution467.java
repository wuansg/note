package top.wuansg.note.leetcode;

import top.wuansg.note.util.Assertions;

//把字符串 s 看作是 “abcdefghijklmnopqrstuvwxyz” 的无限环绕字符串，所以 s 看起来是这样的：
//
//
// "...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd...." .
//
//
// 现在给定另一个字符串 p 。返回 s 中 唯一 的 p 的 非空子串 的数量 。
//
//
//
// 示例 1:
//
//
//输入: p = "a"
//输出: 1
//解释: 字符串 s 中只有一个"a"子字符。
//
//
// 示例 2:
//
//
//输入: p = "cac"
//输出: 2
//解释: 字符串 s 中的字符串“cac”只有两个子串“a”、“c”。.
//
//
// 示例 3:
//
//
//输入: p = "zab"
//输出: 6
//解释: 在字符串 s 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。
//
//
//
//
// 提示:
//
//
// 1 <= p.length <= 10⁵
// p 由小写英文字母构成
//
public class Solution467 {

    public static void main(String[] args) {
        Solution467 solution467 = new Solution467();
        Assertions.assertEquals(1, solution467.findSubstringInWraproundString("a"));
        Assertions.assertEquals(2, solution467.findSubstringInWraproundString("cac"));
        Assertions.assertEquals(6, solution467.findSubstringInWraproundString("zab"));
        Assertions.assertEquals(3, solution467.findSubstringInWraproundString("aabb"));
        Assertions.assertEquals(3, solution467.findSubstringInWraproundString("abaab"));
    }

    public int findSubstringInWraproundString(String p) {
        char[] chars = p.toCharArray();
        int[] cnt = new int[26];
        int tmp = 1;
        cnt[chars[0] - 'a'] = tmp;
        for (int i = 1; i < chars.length; i++) {
            if ((chars[i] - chars[i-1] + 26) % 26 == 1) {
                tmp++;
                cnt[chars[i] - 'a'] = Math.max(tmp, cnt[chars[i] - 'a']);
            } else {
                tmp = 1;
                cnt[chars[i] - 'a'] = Math.max(1, cnt[chars[i] - 'a']);
            }
        }
        int count = 0;
        for (int i : cnt) {
            count += i;
        }
        return count;
    }
}
