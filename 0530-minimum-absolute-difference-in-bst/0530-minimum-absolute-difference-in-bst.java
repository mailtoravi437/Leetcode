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
    int prev = Integer.MAX_VALUE,diff=Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return diff;
    }
    
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        
        inorder(root.left);
            diff = Math.min(diff,Math.abs(root.val-prev));
        
        
        prev = root.val;
        inorder(root.right);
    }
}