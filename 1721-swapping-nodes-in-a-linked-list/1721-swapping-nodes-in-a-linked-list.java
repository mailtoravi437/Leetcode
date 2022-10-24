/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        
        ListNode first = head;
        ListNode second = head;
        
        for(int i=0;i<k-1;i++){
            fast = fast.next;
        }
        
        first = fast;
        
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        second = slow;
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
        
        return head;
    }
}