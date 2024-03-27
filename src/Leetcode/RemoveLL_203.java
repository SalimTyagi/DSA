package Leetcode;

import static Leetcode.MiddleOfLL_876.display;

public class RemoveLL_203 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);
        System.out.println("Input:::");
        display(head);
        int val = 6;
        head = removeNodeOccurrence(head,val);
        System.out.println("output::::");
        display(head);
    }

    private static ListNode removeNodeOccurrence(ListNode head, int val) {
        while (head!=null && head.val==val){
            head = head.next;
        }
        ListNode curr = head.next;
        ListNode prev = head;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                curr = prev;
                curr = curr.next;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return head;
    }
}
