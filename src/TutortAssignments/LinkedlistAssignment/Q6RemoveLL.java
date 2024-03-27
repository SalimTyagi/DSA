package TutortAssignments.LinkedlistAssignment;

public class Q6RemoveLL {
    public static void main(String[] args) {

    }

    public ListNode approach1(ListNode head, int val){
        if(head==null){
            return head;
        }
        while(head!=null && head.val==val){
            head=head.next;
        }
        if(head==null){
            return head;
        }else{

            ListNode curr = head.next;
            ListNode prev = head;
            while(curr!=null){
                if(curr.val==val){
                    prev.next = prev.next.next;
                    curr = prev;
                    curr = curr.next;
                }else{
                    curr = curr.next;
                    prev = prev.next;
                }

            }
        }

        return head;
    }
}
