package LinkedList;

public class RemoveNthNodeFromTheEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if (n == 1 && head.next == null) {
            return null;
        }
        ListNode firstNode = dummy;
        ListNode secondNode = dummy;
        for (int a = 1; a <= n + 1; a++) {
            secondNode = secondNode.next;
        }
        while (secondNode != null) {
            secondNode = secondNode.next;
            firstNode = firstNode.next;
        }
        firstNode.next = firstNode.next.next;
        return dummy.next;
    }
}
