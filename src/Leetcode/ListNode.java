package Leetcode;

public class ListNode {

   public int val;
   public ListNode next;

    public ListNode(int data) {
        this.val = data;
    }

    public ListNode(int data, ListNode next) {
        this.val = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + val +
                ", next=" + next +
                '}';
    }
}
