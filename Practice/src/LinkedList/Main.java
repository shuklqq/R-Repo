package LinkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args){
//        LambdaOnCollections l = new LambdaOnCollections();
//        l.executeAll();
        ListNode l1 = new ListNode(5, null);
        ListNode l2 = new ListNode(4, l1);
        ListNode l3 = new ListNode(3, l2);
        ListNode l4 = new ListNode(2, l3);
        ListNode l5 = new ListNode(1, l4);

        RemoveNthNodeFromTheEnd r = new RemoveNthNodeFromTheEnd();
        ListNode res = r.removeNthFromEnd(l2,2);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }

    }
}
