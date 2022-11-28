class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        sol(nums,ans,res);
        return ans;
    }
    
    public void sol(int nums[],List<List<Integer>> ans,List<Integer> res){
        if(res.size()==nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(res.contains(nums[i])){
                continue;
            }
            
            res.add(nums[i]);
            sol(nums,ans,res);
            res.remove(res.size()-1);
        }
    }
}