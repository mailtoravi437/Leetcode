class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        
        solve(candidates,ans,res,target,0);
        return ans;
    }
    
    public void solve(int candidates[],List<List<Integer>> ans,List<Integer> res,int target,int idx){
        if(target<0){
            return;
        }
        else if(target==0){
            ans.add(new ArrayList<>(res));
            return;
        }
        else{
            for(int i=idx;i<candidates.length;i++){
                if(i>idx && candidates[i]==candidates[i-1]){continue;}
                res.add(candidates[i]);
                solve(candidates,ans,res,target-candidates[i],i+1);
                res.remove(res.size()-1);
            }
        }
    }
}