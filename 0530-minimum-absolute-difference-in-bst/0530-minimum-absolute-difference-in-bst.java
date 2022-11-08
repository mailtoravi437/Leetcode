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
    int prev = Integer.MAX_VALUE,diff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return diff;
    }
    
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        
        dfs(root.left);
        diff = Math.min(diff,Math.abs(root.val-prev));
        prev = root.val;
        dfs(root.right);
    }
}