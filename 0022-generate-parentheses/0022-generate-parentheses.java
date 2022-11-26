class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        sol(res,0,0,"",n);
        return res;
    }
    
    public void sol(List<String> res,int open,int close,String str,int max){
        if(str.length()==2*max){
            res.add(str);
            return;
        }
        
        if(open<max){
            sol(res,open+1,close,str+"(",max);
        }
        if(close<open){
            sol(res,open,close+1,str+")",max);
        }
    }
}