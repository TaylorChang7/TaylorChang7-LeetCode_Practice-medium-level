/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
        Start-time: 2:54
        Iterate through two linked-lists. There will be 4 cases:
        For each iteration, we create a new linked list node unless we fall into case 4.
        Case 1:
        L1 != null and L2 != null:
      
        Case 2:
        L1 != null and L2 == null
        
        Case 3:
        L1 == null and L2 != null
        
        
        Case 4:
        L1 == null and L2 == null
        
        We have to declare a variable "remain" to keep track of the value of a sum between two digits that has value greater or equal to 10. 
        
        */
        int sum = 0;
        int remain = 0;
        ListNode dummy = new ListNode();
        ListNode res = dummy; // Keep track of the node to return later
        boolean signal = false;
        while (signal == false) {
            if (l1 != null && l2 != null) {
                sum = remain + l1.val + l2.val;
                 if (sum >= 10) {
                     remain = 1;
                     sum = sum % 10; //get the right most digit of a number  
                 } else {
                     remain = 0;
                 }
                ListNode new_node = new ListNode(sum);
                dummy.next = new_node;
                
                // Update pointers
                dummy = dummy.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null && l2 == null) {
                sum = l1.val + remain;
                if (sum >= 10) {
                    remain = 1;
                    sum = sum % 10; //get the right most digit of a number  
                } else {
                    remain = 0;
                }
                ListNode new_node = new ListNode(sum);
                dummy.next = new_node;
                dummy = dummy.next;
                l1 = l1.next;
            } else if (l1 == null && l2 != null) {
                System.out.println(sum);
                sum = l2.val + remain;
                if (sum >= 10) {
                    remain = 1;
                    sum = sum % 10; //get the right most digit of a number  
                } else {
                    remain = 0;
                }
                ListNode new_node = new ListNode(sum);
                dummy.next = new_node;
                dummy = dummy.next;
                l2 = l2.next;
            } else {
                signal = true; 
            }
        }
        // Remember: there will be a case where the last two digits add up to have a value greater than 10. 
        // For example: 99 + 10 = 109
        // In this case, we must create an extra node for that extra digit 
        if (remain == 1) {
            ListNode new_node = new ListNode(1);
            dummy.next = new_node;
            dummy = dummy.next;
        }
        return res.next;
    }
}
