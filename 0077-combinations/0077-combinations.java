class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        
        sol(n,k,1,ans,res);
        return res;
    }
    
    public void sol(int n,int k,int start,List<Integer> ans,List<List<Integer>> res){
        if(k==0){
            res.add(new ArrayList<>(ans));
            return;
        }
        for(int i=start;i<=n;i++){
            ans.add(i);
            sol(n,k-1,i+1,ans,res);
            ans.remove(ans.size()-1);
        }
    }
}