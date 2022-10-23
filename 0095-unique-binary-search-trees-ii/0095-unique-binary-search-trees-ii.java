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
    public List<TreeNode> generateTrees(int n) {
        return sol(1,n);
    }
    
    public List<TreeNode> sol(int s,int e){
        List<TreeNode> res = new LinkedList<TreeNode>();
        if(s>e){
            res.add(null);
            return res;
        }
        
        for(int i=s;i<=e;i++){
            List<TreeNode> leftTree = sol(s,i-1);
            List<TreeNode> rightTree = sol(i+1,e);
            
            for(TreeNode l : leftTree){
                for(TreeNode r : rightTree){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        
        return res;
    }
}