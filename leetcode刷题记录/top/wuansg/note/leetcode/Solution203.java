package top.wuansg.note.leetcode;

import top.wuansg.note.leetcode.structure.ListNode;
import top.wuansg.note.util.Assertions;
import top.wuansg.note.util.ListUtils;

public class Solution203 {

    public static void main(String[] args) {
        Solution203 solution203 = new Solution203();
        int[] nodes = new int[]{1,2,6,3,4,5,6};
        int[] expire = new int[]{1,2,3,4,5};
        int target = 6;
        ListNode listNode = ListUtils.generateFromArray(nodes);
        Assertions.assertEquals(expire, solution203.removeElements(listNode, target));
        nodes = new int[]{};
        target = 1;
        expire = new int[]{};
        listNode = ListUtils.generateFromArray(nodes);
        Assertions.assertEquals(expire, solution203.removeElements(listNode, target));
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode nh = new ListNode();
        nh.next = head;
        ListNode temp = nh;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
                continue;
            }
            temp = temp.next;
        }
        return nh.next;
    }
}
