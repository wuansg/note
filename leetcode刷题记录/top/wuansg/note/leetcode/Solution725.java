package top.wuansg.note.leetcode;

import top.wuansg.note.leetcode.structure.ListNode;

/**
 * @author wunansheng
 * @since 2021/9/22
 */
public class Solution725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        if (head == null) return result;
        int count = 0;
        ListNode tmp = head;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        int length = count / k;
        int more = count % k;
        tmp = head;
        for (int i = 0; i < k; i++) {
            result[i] = new ListNode();
            ListNode node = result[i];
            for (int j = 0; j < length; j++) {
                node.next = tmp;
                tmp = tmp.next;
                node = node.next;
                node.next = null;
            }
            if (i < more) {
                node.next = tmp;
                tmp = tmp.next;
                node = node.next;
                node.next = null;
            }
            result[i] = result[i].next;
        }
        return result;
    }
}
