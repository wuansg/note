package top.wuansg.note.leetcode;

public class Solution278 {
    int fistBadVersion;

    public static void main(String[] args) {
        Solution278 solution278 = new Solution278();
        solution278.fistBadVersion = 4;
        int result = solution278.firstBadVersion(15);
        System.out.println(result == solution278.fistBadVersion);
    }

    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int mid = n;
        while (start < end) {
            mid = start + (end - start) >> 1;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return isBadVersion(mid) ? mid : mid + 1;
    }

    public boolean isBadVersion(int version) {
        return fistBadVersion <= version;
    }
}
