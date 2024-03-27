package Leetcode;

import static Leetcode.MiddleOfLL_876.display;

public class DeleteNode_237 {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Input::::::");
        display(head);
        deleteNode(head.next);
        System.out.println("output:::::");
        display(head);
    }
        public static void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
}
