package test234;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
 * 		solution 1 递归
*/
/*public class Solution {
    ListNode h;
    public boolean isPalindrome(ListNode head) {
         if (head == null) return true;

        if (h == null) h = head;

        boolean tmp = true;        
        if (head.next != null) tmp &= isPalindrome(head.next);

        tmp &= (head.val == h.val);
        h = h.next;
        return tmp;
    }
}*/
/*
 * 		solution2 把链表分成前后两端，后端掉转，看是否相等
*/
		
/*public class Solution {
    public boolean isPalindrome(ListNode head) {

        if(head==null || head.next==null){
            return true;
        }

        ListNode mid = findMiddle(head);
        ListNode midhead = mid.next;

        ListNode reverseHead = reverse(midhead);

        while(reverseHead!=null){
            if(head.val==reverseHead.val){
                head = head.next;
                reverseHead = reverseHead.next;
            }else{
                return false;
            }
        }

        return true;
    }

    public ListNode findMiddle(ListNode head1){
        ListNode fast = head1.next;
        ListNode slow = head1;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverse(ListNode head2){
        ListNode pre = null;
        while(head2!=null){
            ListNode tmp = head2.next;
            head2.next = pre;
            pre = head2;
            head2 = tmp;
        }
        return pre;
    }
}
*/



