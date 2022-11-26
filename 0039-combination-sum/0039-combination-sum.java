class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Arrays.sort(candidates);
        
        sol(candidates,ans,res,0,target);
        return ans;
    }
    
    public void sol(int candidates[],List<List<Integer>> ans,List<Integer> res,int idx,int target){
        if(target<0){
            return;
        }
        
        if(target==0){
            ans.add(new ArrayList<>(res));
        }
        
        
        for(int i=idx;i<candidates.length;i++){
            res.add(candidates[i]);
            sol(candidates,ans,res,i,target-candidates[i]);
            res.remove(res.size()-1);
        }
    }
}