class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> holder = new ArrayList<>();
        dfs(nums,res,holder,0);
        List result = new ArrayList<>(res);
        return result;
    }
    
    public void dfs(int nums[],Set<List<Integer>> res,List<Integer> holder,int idx){
        if(holder.size()>=2){
            res.add(new ArrayList<>(holder));
        }
        
        for(int i=idx;i<nums.length;i++){
            if(holder.size()==0 || holder.get(holder.size()-1)<=nums[i]){
                holder.add(nums[i]);
                dfs(nums,res,holder,i+1);
                holder.remove(holder.size()-1);
            }
        }
    }
}