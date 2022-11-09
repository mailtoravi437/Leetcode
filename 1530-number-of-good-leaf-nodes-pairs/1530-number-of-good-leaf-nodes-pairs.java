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
    int count = 0;
    public int countPairs(TreeNode root, int distance) {
        distance(root,distance);
        return count;
    }
    
    public List<Integer> distance(TreeNode root,int distance){
        if(root==null){
            return new ArrayList<>();
        }
        
        if(root.left==null && root.right==null){
            List<Integer> sublist = new ArrayList<>();
            sublist.add(1);
            return sublist;
        }
        
        List<Integer> l1 = distance(root.left,distance);
        List<Integer> l2 = distance(root.right,distance);
        
        for(int d1 : l1){
            for(int d2 : l2){
                if(d1+d2<=distance){
                    count++;
                }
            }
        }
        List<Integer> alist = new ArrayList<>();
        for(int x : l1){
            alist.add(x+1);
        }
        
        for(int x : l2){
            alist.add(x+1);
        }
        
        return alist;
    }
}