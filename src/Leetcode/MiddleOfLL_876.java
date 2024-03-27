package Leetcode;

public class MiddleOfLL_876 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Input");
        display(head);

        //head = middle(head);
        head = middle2(head);
        System.out.println("Output");
        display(head);
    }

    private static ListNode middle2(ListNode head) {
        ListNode slow = head;
        ListNode fast  = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast =fast.next.next;
        }
        return slow;
    }

    //this is the first approach
    private static ListNode middle(ListNode head) {
        int len = findLength(head);
        int mid = len/2;
        while (mid>0){
            mid--;
            head =head.next;
        }
        return head;
    }

    public static void display(ListNode head){
        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static int findLength(ListNode head) {
        int count = 0;
        ListNode temp =head;
        while (temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }

}
