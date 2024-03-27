package Leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveZeroSumNode_1171 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next=new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(-3);
        head.next.next.next.next = new ListNode(4);
        System.out.println("Input");
        display(head);

        head = deleteZeroSumNode(head);
        System.out.println("ouput");
        display(head);
    }

    private static ListNode deleteZeroSumNode(ListNode head) {
        int prefixSum = 0;

        Map<Integer,ListNode> map =new HashMap<>();
        ListNode dummy = new ListNode(0);
        map.put(0,dummy);
        dummy.next = head;

        while (head!=null){
            prefixSum+=head.val;

            if(!map.containsKey(prefixSum)){
                map.put(prefixSum,head);
            }else {
                ListNode prev = map.get(prefixSum);
                ListNode curr = prev;
                int sum = prefixSum;
                while (curr!=head){
                    curr = curr.next;
                    sum+=curr.val;
                    if(curr!=head){
                        map.remove(sum);
                    }
                }
                prev.next = head.next;
            }
            head =head.next;
        }
        return dummy.next;
    }

    public static void display(ListNode head){
        ListNode temp = head;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
