package TutortAssignments.LinkedlistAssignment;

public class Q5DeleteNode {
    public static void main(String[] args) {

    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
