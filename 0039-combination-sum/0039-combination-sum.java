class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        Arrays.sort(candidates);
        sol(0,candidates,ans,res,target);
        return res;
    }
    
    public void sol(int idx,int candidates[],List<Integer> ans,List<List<Integer>> res,int target){
        if(target<0){
            return;
        }
        
        if(target==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i=idx;i<candidates.length;i++){
            ans.add(candidates[i]);
            sol(i,candidates,ans,res,target-candidates[i]);
            ans.remove(ans.size()-1);
        }
    }
}