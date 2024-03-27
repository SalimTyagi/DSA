package TutortAssignments.LinkedlistAssignment;

public class Q4MiddleOfLL {
    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        int len = findLength(head);
        int mid = len/2;
        while(mid>0){
            head=head.next;
            mid--;
        }
        return head;
    }

    int findLength(ListNode head){
        int count =0;
        ListNode curr = head;
        while(curr!=null){
            count++;
            curr = curr.next;
        }
        return count;
    }
}
