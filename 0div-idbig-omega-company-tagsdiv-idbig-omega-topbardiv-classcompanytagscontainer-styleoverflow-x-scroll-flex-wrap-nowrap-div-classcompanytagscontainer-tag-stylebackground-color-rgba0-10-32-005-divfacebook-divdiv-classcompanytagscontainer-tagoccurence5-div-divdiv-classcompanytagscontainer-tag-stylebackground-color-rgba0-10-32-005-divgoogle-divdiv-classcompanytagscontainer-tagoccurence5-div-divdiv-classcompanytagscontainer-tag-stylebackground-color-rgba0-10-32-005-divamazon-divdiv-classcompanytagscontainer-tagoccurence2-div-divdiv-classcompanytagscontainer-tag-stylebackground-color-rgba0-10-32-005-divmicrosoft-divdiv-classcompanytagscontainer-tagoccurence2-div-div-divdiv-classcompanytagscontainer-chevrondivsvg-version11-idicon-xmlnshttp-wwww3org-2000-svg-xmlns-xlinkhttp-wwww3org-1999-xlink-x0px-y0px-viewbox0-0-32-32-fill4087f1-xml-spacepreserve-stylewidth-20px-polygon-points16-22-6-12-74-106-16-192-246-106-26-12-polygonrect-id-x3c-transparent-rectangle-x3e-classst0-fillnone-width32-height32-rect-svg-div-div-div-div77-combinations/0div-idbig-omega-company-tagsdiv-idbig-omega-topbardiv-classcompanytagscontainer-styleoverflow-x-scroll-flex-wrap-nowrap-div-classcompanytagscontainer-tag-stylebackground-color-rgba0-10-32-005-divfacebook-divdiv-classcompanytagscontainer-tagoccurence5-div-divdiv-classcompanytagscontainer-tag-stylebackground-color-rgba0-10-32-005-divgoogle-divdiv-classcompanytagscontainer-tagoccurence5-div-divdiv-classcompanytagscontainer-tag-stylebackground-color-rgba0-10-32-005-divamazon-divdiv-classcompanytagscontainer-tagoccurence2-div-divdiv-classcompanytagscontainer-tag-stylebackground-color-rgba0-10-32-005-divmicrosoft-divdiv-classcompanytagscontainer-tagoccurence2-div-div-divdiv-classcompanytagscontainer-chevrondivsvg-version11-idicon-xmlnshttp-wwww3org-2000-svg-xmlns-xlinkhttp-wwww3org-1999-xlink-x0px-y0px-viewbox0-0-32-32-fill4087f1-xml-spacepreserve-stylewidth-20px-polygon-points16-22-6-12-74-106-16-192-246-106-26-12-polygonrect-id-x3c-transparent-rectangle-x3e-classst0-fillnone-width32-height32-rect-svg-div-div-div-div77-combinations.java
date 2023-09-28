class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        solve(ans,res,1,n,k);
        return ans;
    }
    
    public void solve(List<List<Integer>> ans,List<Integer> res,int start,int n,int k){
        if(k==0){
            ans.add(new ArrayList<>(res));
            return;
        }
        
        for(int i=start;i<=n;i++){
            res.add(i);
            solve(ans,res,i+1,n,k-1);
            res.remove(res.size()-1);
        }
    }
}