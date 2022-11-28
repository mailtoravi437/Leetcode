class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        boolean vis[] = new boolean[n];
        Arrays.fill(vis,false);
        sol(nums,ans,res,vis);
        return res;
    }
    
    public void sol(int nums[],List<Integer> ans,List<List<Integer>> res,boolean vis[]){
        if(ans.size()==nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(vis[i] ||(i>0 && nums[i-1]==nums[i] && !vis[i-1])){
                continue;
            }
            
            vis[i] = true;
            ans.add(nums[i]);
            sol(nums,ans,res,vis);
            vis[i] = false;
            ans.remove(ans.size()-1);
        }
    }
}