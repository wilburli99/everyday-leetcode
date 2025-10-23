package linked_list;

public class reverse_list_2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        // prev作为left的前一个节点
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
        }
        // 开始反转[left, right]
        ListNode cur = pre.next;
        ListNode prev = null;
        ListNode next = null;
        for (int i = 0; i < right-left+1; i++) {
            next = cur.next; // 标记当前处理点的下一个
            cur.next = prev; // 把后点接到前面
            prev = cur;
            cur = next;
        }
        // 链接前后链表，前端，中端（反转的一端），后端
        pre.next.next = cur; // 原left节点接到尾部
        pre.next = prev; // 头部接到原right节点
        return dummy.next;
    }
}
