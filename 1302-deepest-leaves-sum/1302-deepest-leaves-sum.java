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
    public int deepestLeavesSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int res = 0;
        while(!queue.isEmpty()){
            res = 0;
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                res += temp.val;
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                
                if(temp.right!=null){
                    queue.add(temp.right);
                }
            }
        }
        
        return res;
    }
}