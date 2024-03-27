package TutortAssignments.LinkedlistAssignment;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int data){
        this.val = data;
        this.next = null;
    }

    ListNode(int data, ListNode node){
        this.val = data;
        this.next = node;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + val +
                ", next=" + next +
                '}';
    }
}
