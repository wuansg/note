package top.wuansg.note.leetcode;

import top.wuansg.note.util.Assertions;

import java.util.HashMap;
import java.util.Map;

//给定字符串列表 strs ，返回其中 最长的特殊序列 。如果最长特殊序列不存在，返回 -1 。
//
// 特殊序列 定义如下：该序列为某字符串 独有的子序列（即不能是其他字符串的子序列）。
//
// s 的 子序列可以通过删去字符串 s 中的某些字符实现。
//
//
// 例如，"abc" 是 "aebdc" 的子序列，因为您可以删除"aebdc"中的下划线字符来得到 "abc" 。"aebdc"的子序列还包括
//"aebdc"、 "aeb" 和 "" (空字符串)。
//
//
//
//
// 示例 1：
//
//
//输入: strs = ["aba","cdc","eae"]
//输出: 3
//
//
// 示例 2:
//
//
//输入: strs = ["aaa","aaa","aa"]
//输出: -1
//
//
//
//
// 提示:
//
//
// 2 <= strs.length <= 50
// 1 <= strs[i].length <= 10
// strs[i] 只包含小写英文字母
//
public class Solution522 {

    public static void main(String[] args) {
        Solution522 solution522 = new Solution522();
        Assertions.assertEquals(-1, solution522.findLUSlength(new String[]{"aabbcc", "aabbcc","bc","bcc"}));
        Assertions.assertEquals(-1, solution522.findLUSlength(new String[]{"aabbcc", "aabbcc","c"}));
        Assertions.assertEquals(2, solution522.findLUSlength(new String[]{"aabbcc", "aabbcc","cb"}));
        Assertions.assertEquals(4, solution522.findLUSlength(new String[]{"abaa","aba","cdc","eae"}));
        Assertions.assertEquals(-1, solution522.findLUSlength(new String[]{"aaa","aaa","aa"}));
        Assertions.assertEquals(2, solution522.findLUSlength(new String[]{"aabbcc", "aabbcc","cb","abc"}));
        Assertions.assertEquals(7, solution522.findLUSlength(new String[]{"aabbcc", "aabbcc","bc","bcc","aabbccc"}));
        Assertions.assertEquals(-1, solution522.findLUSlength(new String[]{"a","b","c","d","e","f","a","b","c","d","e","f"}));
    }

    public int findLUSlength(String[] strs) {
        int res = -1;
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = i+1; j < strs.length; j++) {
                String maxStr;
                String minStr;
                if (strs[i].length() > strs[j].length()) {
                    maxStr = strs[i];
                    minStr = strs[j];
                } else {
                    maxStr = strs[j];
                    minStr = strs[i];
                }
                int l = 0, r = 0;
                while (l < maxStr.length() && r < minStr.length()) {
                    if (maxStr.charAt(l) == minStr.charAt(r)) {
                        l++;
                        r++;
                    } else {
                        l++;
                    }
                }
                if (l == maxStr.length() && r != minStr.length()) {
                    if (map.getOrDefault(maxStr, 0) <= 1) {
                        res = Math.max(res, maxStr.length());
                    } else if (map.getOrDefault(minStr, 0) <= 1)  {
                        res = Math.max(res, minStr.length());
                    }
                }
                if (l != maxStr.length() && r == minStr.length()) {
                    if (map.getOrDefault(maxStr, 0) <= 1) {
                        res = Math.max(res, maxStr.length());
                    }
                }
                if (r == minStr.length()) {
                    map.put(minStr, 2);
                }
            }
        }
        return res;
    }
}
