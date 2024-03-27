package TutortAssignments.LinkedlistAssignment;

import java.util.HashMap;
import java.util.Map;

public class Q3RemoveZeroSum {
    public static void main(String[] args) {

    }

    public ListNode removeZeroSumSublists(ListNode head) {
        int prefixSum = 0;
        Map<Integer,ListNode> map = new HashMap<>();

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        map.put(0,dummy);

        while (head!=null){
            prefixSum+=head.val;
            if(!map.containsKey(prefixSum)){
                map.put(prefixSum,head);
            }else {
                ListNode prev = map.get(prefixSum);
                ListNode curr = prev;
                int sum = prefixSum;
                while (curr!=head){
                    sum+=curr.val;
                    curr = curr.next;
                    if(curr!=head){
                        map.remove(sum);
                    }
                }
                prev.next = head.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
