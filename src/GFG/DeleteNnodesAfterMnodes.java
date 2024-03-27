package GFG;

import Leetcode.ListNode;

import static Leetcode.MiddleOfLL_876.display;

public class DeleteNnodesAfterMnodes {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Input");
        display(head);
        int M = 1;
        int N = 1;
        deleteNnodes(head,M,N);
        System.out.println("Output");
        display(head);
    }

    private static void deleteNnodes(ListNode head, int M , int N) {

        ListNode current = head, prev = head;

        while (current != null) {
            // Skip M nodes
            for (int count = 1; count <= M && current != null; count++) {
                prev = current;
                current = current.next;
            }

            // Delete N nodes
            for (int count = 1; count <= N && current != null; count++) {
                prev.next = current.next;
                current = prev.next;
            }
        }
    }
}
