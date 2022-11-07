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
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root,root.val,root.val);
    }
    
    public int dfs(TreeNode root,int mx,int mn){
        if(root==null){
            return mx-mn;
        }
        
        mx = Math.max(mx,root.val);
        mn = Math.min(mn,root.val);
        
        return Math.max(dfs(root.left,mx,mn),dfs(root.right,mx,mn));
    }
}