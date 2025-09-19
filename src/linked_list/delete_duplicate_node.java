package linked_list;

public class delete_duplicate_node {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;

        while (head != null) {
            // 判断是否有重复元素
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                pre.next = head.next; //更新指针指向重复元素后面
            } else {
                pre = pre.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
