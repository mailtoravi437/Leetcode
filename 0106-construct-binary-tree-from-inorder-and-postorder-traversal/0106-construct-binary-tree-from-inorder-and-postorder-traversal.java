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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<n;i++){
            hmap.put(inorder[i],i);
        }
        
        int postIndex[] = {n-1};
        return sol(postorder,hmap,0,n-1,postIndex);
    }
    
    public TreeNode sol(int postorder[],HashMap<Integer,Integer> hmap,int inStart,int inEnd,int postIndex[]){
        if(inStart>inEnd){
            return null;
        }
        
        int rootNode = postorder[postIndex[0]];
        postIndex[0] = postIndex[0]-1;
        
        TreeNode root = new TreeNode(rootNode);
        if(inStart==inEnd){
            return root;
        }
        else{
            int index = hmap.get(rootNode);
                        TreeNode right = sol(postorder,hmap,index+1,inEnd,postIndex);

            TreeNode left = sol(postorder,hmap,inStart,index-1,postIndex);
            
            root.left = left;
            root.right = right;
            
            return root;
        }
    }
}