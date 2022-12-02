class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        sol(res,0,0,"",n);
        return res;
    }
    
    public void sol(List<String> res,int open,int close,String curr,int n){
        if(curr.length()==2*n){
            res.add(curr);
            return;
        }
        
        if(open<n){
            sol(res,open+1,close,curr+"(",n);
        }
        
        if(close<open){
            sol(res,open,close+1,curr+")",n);
        }
        
    }
}