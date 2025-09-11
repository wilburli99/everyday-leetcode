package linked_list;

public class delete_node {
    public void deleteNode(ListNode node) {
        // 因为给的节点不是最后一个，所以node.next != null
        // 将 node.next.val赋给 node
        node.val = node.next.val;
        // 将node的指针指向node.next后面
        node.next = node.next.next;
    }
}
