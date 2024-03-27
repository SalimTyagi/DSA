package TutortAssignments.LinkedlistAssignment;

public class Q2DeleteNNodesAfterMNodes {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        int M = 3;
        int N = 2;

        System.out.println("Original Linked List:");
        display(head);

        deleteNodes(head, M, N);

        System.out.println("Linked List after deleting nodes:");
        display(head);
    }

    private static void deleteNodes(ListNode head, int M, int N) {
        ListNode curr = head, prev = null;
        int count;
        while (curr!=null) {
            //skip M nodes
            for (count = 1; count <= M && curr != null; count++) {
                prev = curr;
                curr = curr.next;
            }

            //delete N nodes
            for (count = 1; count <= N && curr != null; count++) {
                prev.next = curr.next;
                curr = prev.next;

            }
        }
    }

    static void linkdelete(ListNode head, int M, int N)
    {
        ListNode curr = head;
        ListNode prev = head;
        int i=1;
        while(curr!=null && i<M){
            i++;
            curr = curr.next;
            if(curr==null){
                return;
            }
        }
        prev = curr;
        i=0;
        while(prev!=null && i<N){
            i++;
            prev=prev.next;
            if(prev==null){
                return;
            }
        }
        if(prev!=null){
            curr.next = prev.next;
            if(prev.next!=null){
                linkdelete(prev.next,M,N);
            }
        }

    }

    static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

}
