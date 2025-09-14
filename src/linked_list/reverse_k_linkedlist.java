package linked_list;

public class reverse_k_linkedlist {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while (true) {
            // 检查剩余是否 >= k 个节点
            ListNode end = pre;
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break; // 不足 k 个，结束

            // 记录下一段的起点
            ListNode next = end.next;

            // 翻转 [pre.next, end] 这一段
            ListNode start = pre.next;
            end.next = null;
            pre.next = reverse(start);

            // 接回链表
            start.next = next;
            pre = start;
        }

        return dummy.next;
    }

    // 翻转链表
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
