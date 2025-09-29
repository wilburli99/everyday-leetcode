package linked_list;

public class delete_n_node {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        int len = length(head); // 计算长度
        for (int i = 0; i < len - n; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    private int length(ListNode head) {
        ListNode tmp = head;
        int n = 0;
        while (tmp != null) {
            tmp = tmp.next;
            n++;
        }
        return n;
    }
}
