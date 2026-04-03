package LinkedList;

public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        ListNode firstHead = head;
        ListNode temp = null;
        ListNode traverse = head;
        int count = 0, sum = 0;
        while(traverse != null){
            count++;
            traverse = traverse.next;
        }
        System.out.println("Count : " + count);
        for(int a = 0 ; a <  count/2 ; a++){
            System.out.println("Head : " + head.val);
            temp = head;
            head = head.next;

        }
        temp.next = null;
        traverse = head;
        head = head.next;
        traverse.next = null;
        while(head != null){
            temp = head;
            head = head.next;
            temp.next = traverse;
            traverse = temp;
            System.out.println("Traverse :" + traverse.val + " | temp : " + temp.val + " | head : " + head );
        }
        while(firstHead != null){
            int b = firstHead.val + traverse.val;
            System.out.println("b : " + b);
            if(b >= sum){
                sum = b;
            }
            firstHead = firstHead.next;
            traverse = traverse.next;
        }
        return sum;
    }
}
