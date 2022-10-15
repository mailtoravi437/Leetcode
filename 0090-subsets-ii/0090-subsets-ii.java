class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        sol(nums,ans,res,0);
        return ans;
    }
    
    public void sol(int nums[],List<List<Integer>> ans,List<Integer> res,int i){
        ans.add(new ArrayList<>(res));
        
        if(i==nums.length){
            return;
        }
        
        for(int idx=i;idx<nums.length;idx++){
            if(idx>i && nums[idx]==nums[idx-1]){
                continue;
            }
                            res.add(nums[idx]);

            
            sol(nums,ans,res,idx+1);
            res.remove(res.size()-1);
        }
    }
}