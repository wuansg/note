package top.wuansg.note.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
//
//
//
// 示例 1：
//
//
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
//
//
// 示例 2：
//
//
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
//
//
// 示例 3：
//
//
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 由小写英文字母组成
// 1 <= words.length <= 5000
// 1 <= words[i].length <= 30
// words[i] 由小写英文字母组成
//
public class Solution30 {

    public static void main(String[] args) {
        Solution30 solution30 = new Solution30();
        solution30.findSubstring("wordgoodgoodgoodbestword", new String[]{"best", "word", "good", "good"});
    }

    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int wl = words[0].length(), wc = words.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Map<String, Integer> temp = new HashMap<>();
            for (int j = i; j <= s.length() - wl; j+=wl) {
                String sub = s.substring(j, j+wl);
                temp.put(sub, temp.getOrDefault(sub, 0)+1);
                if (j == i + (wc-1)*wl) {
                    if (map.equals(temp)) res.add(i);
                }
                if (temp.get(sub) > map.getOrDefault(sub, 0)) break;
            }
        }
        return res;
    }
}
