class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        Arrays.sort(nums);
        backtrack(nums,ans,res,0);
            
        return ans;
    }
    
    public void backtrack(int nums[],List<List<Integer>> ans,List<Integer> res,int start){
        ans.add(new ArrayList<>(res));
        
        
        for(int i=start;i<nums.length;i++){
            res.add(nums[i]);
            backtrack(nums,ans,res,i+1);
            res.remove(res.size()-1);
        }
        
        
    }
}