package top.wuansg.note.leetcode;

public class Solution657 {

    public boolean judgeCircle(String moves) {
        int up = 0;
        int left = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'R':
                    left--;
                    break;
                case 'L':
                    left++;
                    break;
                case 'U':
                    up++;
                    break;
                case 'D':
                    up--;
                    break;
            }
        }
        return up == 0 && left == 0;
    }
}
