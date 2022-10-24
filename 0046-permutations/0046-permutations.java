class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        sol(res,ans,nums);
        return ans;
    }
    
    public void sol(List<Integer> res,List<List<Integer>> ans,int nums[]){
        if(res.size()==nums.length){
            ans.add(new ArrayList<>(res));
        }
        
        for(int i=0;i<nums.length;i++){
            if(res.contains(nums[i])){
                continue;
            }
            res.add(nums[i]);
            sol(res,ans,nums);
            res.remove(res.size()-1);
        }
    }
}