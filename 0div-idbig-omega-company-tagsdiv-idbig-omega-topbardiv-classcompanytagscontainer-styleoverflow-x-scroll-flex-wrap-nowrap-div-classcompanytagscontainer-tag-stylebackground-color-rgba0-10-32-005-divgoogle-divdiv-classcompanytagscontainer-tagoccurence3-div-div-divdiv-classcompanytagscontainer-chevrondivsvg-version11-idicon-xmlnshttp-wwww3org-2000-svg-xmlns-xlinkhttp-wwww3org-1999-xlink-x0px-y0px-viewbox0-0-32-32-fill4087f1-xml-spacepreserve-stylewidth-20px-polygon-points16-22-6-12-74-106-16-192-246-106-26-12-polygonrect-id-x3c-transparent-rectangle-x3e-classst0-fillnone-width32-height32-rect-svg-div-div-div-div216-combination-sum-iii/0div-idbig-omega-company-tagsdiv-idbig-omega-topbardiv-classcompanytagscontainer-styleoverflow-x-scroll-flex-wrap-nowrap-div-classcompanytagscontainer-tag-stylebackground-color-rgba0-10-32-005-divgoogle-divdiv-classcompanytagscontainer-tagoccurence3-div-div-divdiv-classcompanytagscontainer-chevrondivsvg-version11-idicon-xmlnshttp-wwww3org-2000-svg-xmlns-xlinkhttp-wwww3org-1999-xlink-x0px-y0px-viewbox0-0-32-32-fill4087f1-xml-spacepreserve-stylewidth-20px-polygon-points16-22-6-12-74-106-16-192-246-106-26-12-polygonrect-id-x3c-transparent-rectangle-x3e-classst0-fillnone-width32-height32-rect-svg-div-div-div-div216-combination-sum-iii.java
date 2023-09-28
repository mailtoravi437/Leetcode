class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        solve(res,ans,1,n,k);
        return res;
    }
    
    public void solve(List<List<Integer>> res,List<Integer> ans,int idx,int n,int k){
        if(n==0 && ans.size()==k){
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i=idx;i<=9;i++){
            ans.add(i);
            solve(res,ans,i+1,n-i,k);
            ans.remove(ans.size()-1);
        }
    }
}