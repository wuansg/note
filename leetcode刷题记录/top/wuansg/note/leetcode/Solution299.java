package top.wuansg.note.leetcode;

public class Solution299 {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            bulls += secret.charAt(i) == guess.charAt(i) ? 1 : 0;
        }
        int[] bits = new int[10];
        for (char c : secret.toCharArray()) {
            bits[c - '0']++;
        }
        for (char c : guess.toCharArray()) {
            cows += bits[c - '0']-- > 0 ? 1 : 0;
        }
        return String.format("%sA%sB", bulls, cows - bulls);
    }
}
