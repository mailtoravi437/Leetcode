class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        sol(0,res,0,0,"",n);
        return res;
    }
    
    public void sol(int idx,List<String> res,int open,int close,String str,int n){
        if(str.length()==2*n){
            res.add(str);
            return;
        }
        
        if(open<n){
            sol(idx+1,res,open+1,close,str+"(",n);
        }
        
        if(close<open){
            sol(idx+1,res,open,close+1,str+")",n);
        }
    }
}