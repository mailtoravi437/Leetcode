class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        solve(ans,res,candidates,target,0);
        return ans;
    }
    
    public void solve(List<List<Integer>> ans,List<Integer> res,int candidates[],int target,int index){
        if(target<0){
            return;
        }
        
        else if(target==0){
            ans.add(new ArrayList<>(res));
            return;
        }
        else{
            for(int i=index;i<candidates.length;i++){
                res.add(candidates[i]);
                solve(ans,res,candidates,target-candidates[i],i);
                res.remove(res.size()-1);
            }
        }
        
    }
}