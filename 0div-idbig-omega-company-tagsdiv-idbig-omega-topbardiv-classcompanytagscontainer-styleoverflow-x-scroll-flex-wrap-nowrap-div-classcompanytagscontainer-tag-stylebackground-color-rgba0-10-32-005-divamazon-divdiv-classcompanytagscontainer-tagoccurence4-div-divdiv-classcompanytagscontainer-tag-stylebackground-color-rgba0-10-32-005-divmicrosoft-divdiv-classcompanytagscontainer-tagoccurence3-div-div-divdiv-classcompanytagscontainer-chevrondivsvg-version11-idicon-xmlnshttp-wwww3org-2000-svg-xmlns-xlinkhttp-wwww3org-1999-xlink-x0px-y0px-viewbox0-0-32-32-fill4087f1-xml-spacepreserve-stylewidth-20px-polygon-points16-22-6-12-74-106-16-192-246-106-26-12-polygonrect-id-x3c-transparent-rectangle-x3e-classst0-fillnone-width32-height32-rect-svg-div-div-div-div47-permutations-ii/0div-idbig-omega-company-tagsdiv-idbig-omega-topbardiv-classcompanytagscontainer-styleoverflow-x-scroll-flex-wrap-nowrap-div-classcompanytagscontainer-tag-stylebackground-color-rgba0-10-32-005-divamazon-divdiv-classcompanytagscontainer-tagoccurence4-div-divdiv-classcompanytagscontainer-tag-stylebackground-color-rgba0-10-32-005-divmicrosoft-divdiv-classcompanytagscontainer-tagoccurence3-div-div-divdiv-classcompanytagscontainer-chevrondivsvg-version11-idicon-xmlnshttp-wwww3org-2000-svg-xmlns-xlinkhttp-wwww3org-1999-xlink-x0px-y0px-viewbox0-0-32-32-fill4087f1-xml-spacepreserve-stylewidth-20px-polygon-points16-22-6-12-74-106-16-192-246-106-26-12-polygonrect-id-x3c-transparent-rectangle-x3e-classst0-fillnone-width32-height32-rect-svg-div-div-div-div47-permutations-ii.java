class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean used[] = new boolean[nums.length];
        
        solve(nums,res,ans,used);
        return res;
    }
    
    public void solve(int nums[],List<List<Integer>> res,List<Integer> ans,boolean used[]){
        if(ans.size()==nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }
            
            ans.add(nums[i]);
            used[i] = true;
            solve(nums,res,ans,used);
            ans.remove(ans.size()-1);
            used[i] = false;
        }
    }
}