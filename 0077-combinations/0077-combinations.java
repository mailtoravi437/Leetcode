class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        
        sol(n,k,1,ans,res);
        return ans;
    }
    
    public void sol(int n,int k,int start,List<List<Integer>> ans,List<Integer> res){
        if(k==0){
            ans.add(new ArrayList<>(res));
            return;
        }
        
        for(int i=start;i<=n;i++){
            res.add(i);
            sol(n,k-1,i+1,ans,res);
            res.remove(res.size()-1);
        }
    }
}