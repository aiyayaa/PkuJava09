/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null; //
        ListNode temp = head.next;
        ListNode rhead = head;
        
        while(temp != null) {
            if(head.val ==temp.val) {
                head.next = temp.next;
                temp = temp.next;
            } else {
            temp = temp.next;
            head = head.next;   
            }
            
        }
        return rhead;
    }
}