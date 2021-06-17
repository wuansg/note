package top.wuansg.note.leetcode;

import top.wuansg.note.util.Assertions;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wuansg
 * @since 2021/6/17
 */
public class Solution65 {

    public static void main(String[] args) {
        Solution65 solution65 = new Solution65();
        String case1 = "0";
        Assertions.assertTrue(solution65.isNumber(case1));
        String case2 = "e";
        Assertions.assertFalse(solution65.isNumber(case2));
        String case3 = ".";
        Assertions.assertFalse(solution65.isNumber(case3));
        String case4 = ".1";
        Assertions.assertTrue(solution65.isNumber(case4));
        String case5 = "99e2.5";
        Assertions.assertFalse(solution65.isNumber(case5));
        String case6 = "95e54e53";
        Assertions.assertFalse(solution65.isNumber(case6));
        String case7 = "-+3";
        Assertions.assertFalse(solution65.isNumber(case7));
        String case8 = "+";
        Assertions.assertFalse(solution65.isNumber(case8));
        String case9 = "3e+";
        Assertions.assertFalse(solution65.isNumber(case9));
        String case10 = "+.";
        Assertions.assertFalse(solution65.isNumber(case10));
    }

    public boolean isNumber(String s) {
        Set<Character> validateChar = new HashSet<Character>(){{
            add('e');
            add('E');
            add('.');
            add('+');
            add('-');
        }};
        StringBuilder prefix = new StringBuilder();
        StringBuilder post = new StringBuilder();
        boolean hasE = false;
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c) && !validateChar.contains(c)) {
                return false;
            }
            if ((c == 'E' || c == 'e') && !hasE) {
                hasE = true;
                continue;
            } else if (c == 'E' || c == 'e') {
                return false;
            }
            if (hasE) {
                post.append(c);
            }else {
                prefix.append(c);
            }
        }
        boolean prefixValid = checkPrefixValid(prefix.toString());
        boolean checkPostValid = checkPostValid(post.toString());
        if (hasE && (prefix.length() <= 0 || post.length() <= 0)) {
            return false;
        }
        return prefixValid && checkPostValid;
    }

    private boolean checkPrefixValid(String prefix) {
        boolean hadDot = false;
        boolean hasDigit = false;
        for (int i = 0; i < prefix.toCharArray().length; i++) {
            char c = prefix.charAt(i);
            if ((c == '+' || c == '-') && i != 0) {
                return false;
            }
            if (c == '.' && hadDot) {
                return false;
            } else if (c == '.') {
                hadDot = true;
                continue;
            }
            if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        return hasDigit;
    }

    private boolean checkPostValid(String post) {
        for (int i = 0; i < post.toCharArray().length; i++) {
            char c = post.charAt(i);
            if ((c == '+' || c == '-') && i != 0) {
                return false;
            }
            if (c == '.') {
                return false;
            }
        }
        return !"+".equals(post.trim()) && !"-".equals(post.trim());
    }
}
