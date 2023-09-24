class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        solve(ans,res,nums,0);
        
        return ans;
    }
    
    public void solve(List<List<Integer>> ans,List<Integer> res,int nums[],int idx){
            ans.add(new ArrayList<>(res));
        
        for(int i=idx;i<nums.length;i++){
            res.add(nums[i]);
            solve(ans,res,nums,i+1);
            res.remove(res.size()-1);
        }
    }
}