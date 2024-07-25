package LinkedList;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null, temp = null;
        while(head != null){
            temp = previous;
            previous = head;
            head = head.next;
            previous.next = temp;
        }
        return previous;
    }
}
