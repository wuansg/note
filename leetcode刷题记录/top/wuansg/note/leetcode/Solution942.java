package top.wuansg.note.leetcode;

import java.util.*;

//由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
//
//如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I' 
//如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D' 
//给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
//
//来源：力扣（LeetCode）
//链接：https://leetcode.cn/problems/di-string-match
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// IDID  0 < 1, 1 > 2, 2 < 3, 3 > 4  3 > 2,4 >
public class Solution942 {

    public static void main(String[] args) {
        String string = "DDI";
        System.out.println(Arrays.toString(new Solution942().diStringMatch(string)));
    }

    public int[] diStringMatch(String s) {
        int[] res = new int[s.length() + 1];
        int maxLevel = 0;
        int level = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.computeIfAbsent(level, (integer) -> new ArrayList<>()).add(i);
            level += chars[i] == 'I' ? 1 : -1;
            maxLevel = Math.max(level, maxLevel);
        }
        map.computeIfAbsent(level, (integer) -> new ArrayList<>()).add(s.length());
        int n = s.length();
        while (map.size() > 0) {
            if (map.containsKey(maxLevel)) {
                for (Integer integer : map.get(maxLevel)) {
                    res[integer] = n--;
                }
                map.remove(maxLevel);
            }
            maxLevel--;
        }
        return res;
    }
}
