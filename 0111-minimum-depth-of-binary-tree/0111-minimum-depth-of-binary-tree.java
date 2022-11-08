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
    public int minDepth(TreeNode root) {
        int level = 0;
        if(root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                if(temp.left==null && temp.right==null){
                    return level;
                }
                
                if(temp.left!=null){
                queue.add(temp.left);
                }
                
                if(temp.right!=null){
                queue.add(temp.right);
                }
            }
        }
        return level;
    }
}