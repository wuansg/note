package top.wuansg.note.leetcode;

import top.wuansg.note.util.Assertions;

import java.util.*;
import java.util.stream.Collectors;

//基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。
//
// 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。
//
//
// 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。
//
//
// 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。
//
// 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成
//此基因变化，返回 -1 。
//
// 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。
//
//
//
// 示例 1：
//
//
//输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
//输出：1
//
//
// 示例 2：
//
//
//输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA",
//"AAACGGTA"]
//输出：2
//
//
// 示例 3：
//
//
//输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC",
//"AACCCCCC"]
//输出：3
//
//
//
//
// 提示：
//
//
// start.length == 8
// end.length == 8
// 0 <= bank.length <= 10
// bank[i].length == 8
// start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成
//
public class Solution433 {
    static char[] items = new char[]{'A', 'C', 'G', 'T'};

    public static void main(String[] args) {
        Solution433 solution433 = new Solution433();
        Assertions.assertEquals(3, solution433.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC","AAACCCCC","AACCCCCC"}));
    }

    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = Arrays.stream(bank).collect(Collectors.toSet());
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        queue.offer(start);
        map.put(start, 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String s = queue.poll();
                char[] chars = s.toCharArray();
                int step = map.get(s);
                for (int i = 0; i < 8; i++) {
                    for (char item : items) {
                        if (chars[i] == item) continue;
                        char[] clone = chars.clone();
                        clone[i] = item;
                        String s1 = String.valueOf(clone);
                        if (!set.contains(s1)) continue;
                        if (map.containsKey(s1)) continue;
                        if (s1.equals(end)) return step + 1;
                        map.put(s1, step + 1);
                        queue.offer(s1);
                    }
                }
            }
        }
        return -1;
    }
}
