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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode temp = head.next.next;
        ListNode first = head;
        ListNode second = head.next;
        
        head = second;
        head.next = first;
        
        head.next.next = swapPairs(temp);
        return head;
    }
}