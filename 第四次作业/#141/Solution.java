/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {  
  
    public static void main(String[] args) {  
  
    }  
      
    // 经典快慢指针找环问题  
    public boolean hasCycle(ListNode head) {  
        ListNode slow = head, fast = head;  
          
        while(true){  
            if(fast==null || fast.next==null || slow==null){  
                return false;  
            }  
              
            fast = fast.next.next;  
            slow = slow.next;  
              
            if(fast == slow){  
                return true;  
            }  
        }  
    }  
  
}  