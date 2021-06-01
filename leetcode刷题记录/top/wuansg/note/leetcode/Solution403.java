package top.wuansg.note.leetcode;

import java.util.*;

/**
 * @author wunansheng
 * @since 2021/4/29
 */
public class Solution403 {
    public static void main(String[] args) {
        System.out.println(new Solution403().canCross(new int[]{0,1,3,5,6,8,12,17}));
    }

    public boolean canCross(int[] stones) {
        int length = stones[stones.length - 1];
        Set<Integer> dp = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>(8);
        map.put(stones[0], new HashSet<>(Collections.singletonList(1)));

        for (int stone : stones) {
            dp.add(stone);
        }

        for (int i = stones[0]; i < length && !map.isEmpty() && hasContains(dp, map.keySet()); i++) {
            Set<Integer> set = map.get(i);
            map.remove(i);
            if (set == null) {
                continue;
            }
            int cur = i;
            set.forEach(integer -> {
                if (integer > 0 && cur + integer <= length && dp.contains(cur + integer)) {
                    Set<Integer> s2 = map.computeIfAbsent(cur + integer, k -> new HashSet<>());
                    s2.add(integer-1);
                    s2.add(integer);
                    s2.add(integer+1);
                }
            });
        }
        return map.get(length) != null;
    }

    private boolean hasContains(Set<Integer> s1, Set<Integer> s2) {
        return s2.stream().anyMatch(s1::contains);
    }
}
