package top.wuansg.note.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author wunansheng
 * @since 2021/9/17
 */
public class Solution77 {
    List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {
        result = new LinkedList<>();
        backtrace(new Stack<>(), 1, n, k);
        return result;
    }

    private void backtrace(Stack<Integer> stack, int index, int limit, int limitSize) {
        if (stack.size() == limitSize) {
            result.add(new ArrayList<>(stack));
            return;
        }
        if (stack.size() + limit - index + 1 < limitSize) {
            return;
        }
        for (int i = index; i <= limit; i++) {
            stack.push(i);
            backtrace(stack, i+1, limit, limitSize);
            stack.pop();
        }
    }
}
