package top.wuansg.note.leetcode;

import java.util.*;

/**
 * @author wunansheng
 * @since 2021/4/28
 */
public class Solution207 {
    public static void main(String[] args) {
        boolean result = new Solution207().canFinish(2, new int[][]{{1,0}, {0,1}});
        System.out.println(result);
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            List<Integer> list = tree.getOrDefault(prerequisite[0], new ArrayList<>());
            list.add(prerequisite[1]);
            tree.put(prerequisite[0], list);
        }
        Set<Integer> tmp = new HashSet<>();
        Set<Integer> forever = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!check(i, tree, tmp, forever))
                return false;
        }
        return true;
    }

    private boolean check(int i, Map<Integer, List<Integer>> map, Set<Integer> tmp, Set<Integer> forever) {
        if (forever.contains(i)) return true;
        if (tmp.contains(i)) return false;
        List<Integer> list = map.get(i);
        tmp.add(i);
        if (list != null) {
            for (int i1 = 0; i1 < list.size(); i1++) {
                if (!check(list.get(i1), map, tmp, forever))
                    return false;
            }
        }
        tmp.remove(i);
        forever.add(i);
        return true;
    }
}
