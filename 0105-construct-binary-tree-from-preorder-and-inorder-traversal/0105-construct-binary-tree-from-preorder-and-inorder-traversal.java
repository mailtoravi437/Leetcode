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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer,Integer> inmap = new HashMap<>();
        for(int i=0;i<n;i++){
            inmap.put(inorder[i],i);
        }
        
        int preIdx[] = {0};
        return sol(preorder,inmap,0,n-1,preIdx);
    }
    
    public TreeNode sol(int preorder[],HashMap<Integer,Integer> hmap,int inStart,int inEnd,int preIdx[]){
        if(inStart>inEnd){
            return null;
        }
        
        int rootNode = preorder[preIdx[0]];
        preIdx[0] = preIdx[0]+1;
        
        TreeNode root = new TreeNode(rootNode);
        if(inStart==inEnd){
            return root;
        }
        else{
            int index = hmap.get(rootNode);
            TreeNode left = sol(preorder,hmap,inStart,index-1,preIdx);
            TreeNode right = sol(preorder,hmap,index+1,inEnd,preIdx);
            
            root.left = left;
            root.right = right;
            
            return root;
        }
    }
}