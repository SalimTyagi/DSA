package Leetcode;

public class RemoveNthNodeFromEnd_19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);

        System.out.println("Original LL");
        display(head);
        int n = 1;
        //head = removeNthNodeStart(head,n);
        head = removeNthNodeEnd(head,n);

        System.out.println("After remove Nth node");
        display(head);
    }

    private static ListNode removeNthNodeEnd(ListNode head, int n) {
        int len = findLength(head);
        int travereTill = len-n;
        ListNode curr = head;
        ListNode prev = head;
        if(len==n){
            head = head.next;
        }
        while (travereTill>=1){
            prev = curr;
            curr = curr.next;
            travereTill--;
        }
        prev.next = curr.next;
        return head;
    }

    private static ListNode removeNthNodeStart(ListNode head, int n) {
        ListNode curr = head;
        ListNode prev = head;

        while (n>1){
            prev = curr;
            curr = curr.next;
            n--;
        }
        prev.next = curr.next;
        return head;
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

    public static void display(ListNode head){
        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }


}
