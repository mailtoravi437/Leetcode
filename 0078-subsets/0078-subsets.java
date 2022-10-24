class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        sol(0,res,ans,nums);
        return ans;
    }
    
    public void sol(int idx,List<Integer> res,List<List<Integer>> ans,int nums[]){
        ans.add(new ArrayList<>(res));
        for(int i=idx;i<nums.length;i++){
            res.add(nums[i]);
            sol(i+1,res,ans,nums);
            res.remove(res.size()-1);
        }
    }
}