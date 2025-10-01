package linked_list;

public class copy_ramdom_list {
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        // 在每个节点后面加入一个新的复制节点
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }
        // 确定复制节点的random指向
        cur = head;
        while(cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        // 把复制节点拆分出来
        cur = head;
        Node dummy = new Node(0);
        Node copyCur = dummy;
        while(cur != null) {
            copyCur.next = cur.next;
            cur.next = cur.next.next;
            copyCur = copyCur.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
