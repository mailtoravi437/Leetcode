class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        Arrays.sort(candidates);
        List<Integer> res = new ArrayList<>();
        backtrack(candidates,res,ans,target,0);
        return ans;
    }
    
    public void backtrack(int candidates[],List<Integer> res,List<List<Integer>> ans,int target,int start){
        if(target<0){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<>(res));
        }
        
        for(int i=start;i<candidates.length;i++){
            res.add(candidates[i]);
            backtrack(candidates,res,ans,target-candidates[i],i);
            res.remove(res.size()-1);
        }
    }
}