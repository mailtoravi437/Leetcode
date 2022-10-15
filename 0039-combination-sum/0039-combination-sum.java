class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,ans,res,target,0);
        
        return ans;
    }
    
    
    public void backtrack(int candidates[],List<List<Integer>> ans,List<Integer> res,int target,int start){
        if(target<0){
            return;
        }
        
        if(target==0){
            ans.add(new ArrayList<>(res));
        }
        
        for(int i=start;i<candidates.length;i++){
            res.add(candidates[i]);
            backtrack(candidates,ans,res,target-candidates[i],i);
            res.remove(res.size()-1);
        }
    }
    
}