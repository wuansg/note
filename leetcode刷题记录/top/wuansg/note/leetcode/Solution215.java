package top.wuansg.note.leetcode;

import java.util.Arrays;

/**
 * @author wunansheng
 * @since 2021/4/29
 */
public class Solution215 {
    public static void main(String[] args) {
        int k = 7;
        int[] input = new int[]{1,3,34,23,54, 57,21,35,32,56,7,8,4};
        System.out.println(new Solution215().findKthLargest(input, k));
        Arrays.sort(input);
        System.out.println(input[input.length - k]);
    }

    public int findKthLargest(int[] nums, int k) {
        int[] minHeap = new int[k];
        Arrays.fill(minHeap, Integer.MIN_VALUE);
        for (int num : nums) {
            if (num > minHeap[0]) {
                minHeap[0] = num;
                heap(minHeap);
            }
        }
        return minHeap[0];
    }

    private void heap(int[] heap) {
        int i = 0;
        while (i * 2 + 1 < heap.length) {
            int next = i * 2 + 1;
            int min = heap[next];
            if (next + 1 < heap.length && min > heap[next + 1]) {
                min = heap[next + 1];
                next += 1;
            }
            if (min < heap[i]) {
                swap(heap, i, next);
                i = next;
            } else {
                break;
            }
        }
    }

    private void swap(int[] heap, int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }
}
