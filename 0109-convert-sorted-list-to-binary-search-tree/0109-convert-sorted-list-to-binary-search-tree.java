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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        
        return sol(head,null);
    }
    
    public TreeNode sol(ListNode head,ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        
        if(head==tail){
            return null;
        }
        
        while(fast!=tail && fast.next!=tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        
        TreeNode root = new TreeNode(slow.val);
        root.left = sol(head,slow);
        root.right = sol(slow.next,tail);
        return root;
    }
}