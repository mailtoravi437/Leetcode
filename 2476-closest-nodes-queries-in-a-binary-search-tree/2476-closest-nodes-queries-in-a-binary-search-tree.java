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
    TreeMap<Integer,Integer> hmap = new TreeMap<>();
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        inorder(root);
    List<List<Integer>> ans = new ArrayList<>();
    
    for(int x : queries){
        Integer low = hmap.containsKey(x)?Integer.valueOf(x):hmap.lowerKey(x);
        Integer high = hmap.containsKey(x)?Integer.valueOf(x):hmap.higherKey(x);
        ans.add(Arrays.asList(low==null?-1:low,high==null?-1:high));
        
    }
        return ans;
    }
    
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        
        inorder(root.left);
        hmap.put(root.val,0);
        inorder(root.right);
    }
}