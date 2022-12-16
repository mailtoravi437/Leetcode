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
    public boolean findTarget(TreeNode root, int k) {
        if(root==null){
            return false;
        }
        
        Set<Integer> hset = new HashSet<>();
        return sol(root,k,hset);
    }
    
    public boolean sol(TreeNode root,int k,Set<Integer> hset){
        if(root==null){
            return false;
        }
        
        if(hset.contains(k-root.val)){
            return true;
        }
        
        hset.add(root.val);
        return sol(root.left,k,hset) || sol(root.right,k,hset);
    }
}