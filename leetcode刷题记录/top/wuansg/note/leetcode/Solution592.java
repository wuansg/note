package top.wuansg.note.leetcode;

import top.wuansg.note.util.Assertions;

public class Solution592 {

    public static void main(String[] args) {
        Solution592 solution592 = new Solution592();
        Assertions.assertEquals("0/1", solution592.fractionAddition("-1/2+1/2"));
        Assertions.assertEquals("1/3", solution592.fractionAddition("-1/2+1/2+1/3"));
        Assertions.assertEquals("-1/6", solution592.fractionAddition("1/3-1/2"));
        Assertions.assertEquals("41/12", solution592.fractionAddition("7/2+2/3-3/4"));
        Assertions.assertEquals("-13/10", solution592.fractionAddition("-1/4-4/5-1/4"));
        Assertions.assertEquals("-37/60", solution592.fractionAddition("1/3-5/4+3/10"));
    }

    public String fractionAddition(String expression) {
        int ops = 1;
        int index = 0;
        int molecular = 0;
        int denominator = 1;
        while (index < expression.length()) {
            char c = expression.charAt(index);
            if (c == '-') {
                ops = -1;
                index++;
            }
            if (c == '+') {
                ops = 1;
                index++;
            }
            int nextMolecular = 0;
            while (Character.isDigit(expression.charAt(index))) {
                nextMolecular = nextMolecular * 10 + expression.charAt(index) - '0';
                index++;
            }
            int nextDenominator = 0;
            index++;
            while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
                nextDenominator = nextDenominator * 10 + expression.charAt(index) - '0';
                index++;
            }
            if (denominator % nextDenominator == 0) {
                int mul = denominator / nextDenominator;
                molecular = molecular + nextMolecular * ops * mul;
            } else if (nextDenominator % denominator == 0) {
                int mul = nextDenominator / denominator;
                denominator = nextDenominator;
                molecular = molecular * mul + nextMolecular * ops;
            } else {
                molecular = molecular * nextDenominator + nextMolecular * denominator * ops;
                denominator = nextDenominator * denominator;
            }
            if (molecular == 0) denominator = 1;
        }
        int dividend = Math.min(Math.abs(denominator), Math.abs(molecular));
        while (dividend > 1) {
            if (molecular % dividend == 0 && denominator % dividend == 0) {
                molecular /= dividend;
                denominator /= dividend;
                break;
            }
            dividend--;
        }
        return molecular + "/" + denominator;
    }
}
