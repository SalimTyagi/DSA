package TutortAssignments.LinkedlistAssignment;

public class Q1RemoveNthNode {
    public static void main(String[] args) {

    }

    ListNode approach1(ListNode head, int n){
        ListNode slow = head;
        ListNode fast = head;

        while(n>0){
            fast = fast.next;
            n--;
        }
        if(fast==null){
            return head.next;
        }

        while(fast.next!=null){
            fast = fast.next;
            slow= slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }

    ListNode approach2(ListNode head, int n){
        int len = length(head);
        ListNode current = head;
        int traversalTill = len-n;
        int pos = 1;
        while(pos<traversalTill){
            current = current.next;
            pos++;
        }
        if(len==n){
            //base case when we need to remove head
            head = head.next;
        }else{
            current.next = current.next.next;
        }

        return head;
    }

    int length(ListNode head){
        int len=0;
        ListNode curr=head;
        while(curr!=null){
            curr= curr.next;
            len++;
        }
        return len;
    }
}
