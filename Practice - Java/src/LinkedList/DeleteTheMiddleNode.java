package LinkedList;

public class DeleteTheMiddleNode {
    public ListNode deleteMiddle(ListNode head){
        int count = 1;
        System.out.println("Count 1 : " + count);
        count = countAndDeleteMiddle(head, count);
        System.out.println("Count 2 : " + count);
        return head;
    }
    public int countAndDeleteMiddle(ListNode head, int count){
        int a = 0;
        System.out.println("Count 3 : " + count + " | A : " + a);
        if(head.next != null){
            count++;
            System.out.println("Count 4 : " + count + " | A : " + a);
            a = countAndDeleteMiddle(head.next,count);
            System.out.println("Count 5 : " + count + " | A : " + a);
        }
        else{
            System.out.println("Count 6 : " + count + " | A : " + a);
            return count;
        }
        if(a/2 == count - 1){
            System.out.println("Count 7 : " + count + " | A : " + a);
            if(head.next != null){
                System.out.println("Count 8 : " + count + " | A : " + a);
                ListNode b = head.next;
                head.next = b.next;
                System.out.println("Count 9 : " + count + " | A : " + a);
            }else{
                System.out.println("Count 10 : " + count + " | A : " + a);
                head.next = null;
            }
        }
        return a;
    }
}
