package LinkedList;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = null, even = null, oddHead = null, evenHead = null;
        if(head != null){
            odd = head;
            oddHead = odd;
            System.out.println("oddHead 1 : "  + oddHead.getValue() + " | odd : " + odd.getValue());
        }
        head = head.next;
        System.out.println("Head 1 : "  + head.getValue());
        if(head != null){
            even = head;
            evenHead = even;
            System.out.println("evenHead 1 : "  + evenHead.getValue() + " | even : " + even.getValue());
        }
        head = head.next;
        System.out.println("Head 2 : "  + head.getValue());
        while(head != null){
            System.out.println("Head 3 : "  + head.getValue());
            odd.next = head;
            odd = odd.next;
            head = head.next;
            System.out.println("oddHead 2 : "  + oddHead.getValue() + " | odd : " + odd.getValue());
            if(head != null){
                even.next = head;
                even = even.next;
                System.out.println("evenHead 2 : "  + evenHead.getValue() + " | even : " + even.getValue());
                head = head.next;
                System.out.println("evenHead : "  + evenHead.getValue() + " | even : " + even.getValue() + " | Head : "  + head.getValue());
            }
        }
        even.next = null;
        odd.next = evenHead;
        return oddHead;
    }
}
