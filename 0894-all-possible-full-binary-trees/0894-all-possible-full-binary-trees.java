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
    public List<TreeNode> allPossibleFBT(int n) {
        return sol(n);
    }
    
    public List<TreeNode> sol(int n){
        if(n==1){
            TreeNode root = new TreeNode(0);
            List<TreeNode> res = new ArrayList<>();
            res.add(root);
            return res;
        }
        
        List<TreeNode> res = new ArrayList<>();
        for(int i=1;i<n;i+=2){
            List<TreeNode> l = sol(i);
            List<TreeNode> r = sol(n-i-1);
            
            for(TreeNode left : l){
                for(TreeNode right : r){
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    
                    res.add(root);
                    
                }
            }
        }
        
        return res;
    }
}