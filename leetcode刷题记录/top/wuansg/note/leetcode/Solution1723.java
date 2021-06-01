package top.wuansg.note.leetcode;

/**
 * @author wunansheng
 * @since 2021/5/8
 */
public class Solution1723 {
    public static void main(String[] args) {
        int[] jobs = new int[]{9899456,8291115,9477657,9288480,5146275,7697968,8573153,3582365,3758448,9881935,2420271,4542202};
        int k = 9;
        System.out.println(new Solution1723().minimumTimeRequired(jobs, k));
    }

    public int minimumTimeRequired(int[] jobs, int k) {
        long[] times = new long[k];
        int[] min = new int[jobs.length + 1];
        min[min.length-1] = Integer.MAX_VALUE;

        min[0] = jobs[0];
        times[0] = jobs[0];
        backtrace(jobs, times, 1, min);
        return min[min.length-1];
    }

    private void backtrace(int[] jobs, long[] times, int index, int[] min) {
        if (index >= jobs.length) {
            min[min.length-1] = Math.min(min[min.length-1], min[min.length-2]);
            return;
        }

        for (int i = 0; i < times.length; i++) {
            times[i] += jobs[index];
            if (times[i] < min[min.length-1] && (i == 0 || times[i-1] > 0)) {
                min[index] = index == 0 ? (int) times[i] : Math.max(min[index-1], (int) times[i]);
                backtrace(jobs, times, index+1, min);
            }
            times[i] -= jobs[index];
        }
    }

}
