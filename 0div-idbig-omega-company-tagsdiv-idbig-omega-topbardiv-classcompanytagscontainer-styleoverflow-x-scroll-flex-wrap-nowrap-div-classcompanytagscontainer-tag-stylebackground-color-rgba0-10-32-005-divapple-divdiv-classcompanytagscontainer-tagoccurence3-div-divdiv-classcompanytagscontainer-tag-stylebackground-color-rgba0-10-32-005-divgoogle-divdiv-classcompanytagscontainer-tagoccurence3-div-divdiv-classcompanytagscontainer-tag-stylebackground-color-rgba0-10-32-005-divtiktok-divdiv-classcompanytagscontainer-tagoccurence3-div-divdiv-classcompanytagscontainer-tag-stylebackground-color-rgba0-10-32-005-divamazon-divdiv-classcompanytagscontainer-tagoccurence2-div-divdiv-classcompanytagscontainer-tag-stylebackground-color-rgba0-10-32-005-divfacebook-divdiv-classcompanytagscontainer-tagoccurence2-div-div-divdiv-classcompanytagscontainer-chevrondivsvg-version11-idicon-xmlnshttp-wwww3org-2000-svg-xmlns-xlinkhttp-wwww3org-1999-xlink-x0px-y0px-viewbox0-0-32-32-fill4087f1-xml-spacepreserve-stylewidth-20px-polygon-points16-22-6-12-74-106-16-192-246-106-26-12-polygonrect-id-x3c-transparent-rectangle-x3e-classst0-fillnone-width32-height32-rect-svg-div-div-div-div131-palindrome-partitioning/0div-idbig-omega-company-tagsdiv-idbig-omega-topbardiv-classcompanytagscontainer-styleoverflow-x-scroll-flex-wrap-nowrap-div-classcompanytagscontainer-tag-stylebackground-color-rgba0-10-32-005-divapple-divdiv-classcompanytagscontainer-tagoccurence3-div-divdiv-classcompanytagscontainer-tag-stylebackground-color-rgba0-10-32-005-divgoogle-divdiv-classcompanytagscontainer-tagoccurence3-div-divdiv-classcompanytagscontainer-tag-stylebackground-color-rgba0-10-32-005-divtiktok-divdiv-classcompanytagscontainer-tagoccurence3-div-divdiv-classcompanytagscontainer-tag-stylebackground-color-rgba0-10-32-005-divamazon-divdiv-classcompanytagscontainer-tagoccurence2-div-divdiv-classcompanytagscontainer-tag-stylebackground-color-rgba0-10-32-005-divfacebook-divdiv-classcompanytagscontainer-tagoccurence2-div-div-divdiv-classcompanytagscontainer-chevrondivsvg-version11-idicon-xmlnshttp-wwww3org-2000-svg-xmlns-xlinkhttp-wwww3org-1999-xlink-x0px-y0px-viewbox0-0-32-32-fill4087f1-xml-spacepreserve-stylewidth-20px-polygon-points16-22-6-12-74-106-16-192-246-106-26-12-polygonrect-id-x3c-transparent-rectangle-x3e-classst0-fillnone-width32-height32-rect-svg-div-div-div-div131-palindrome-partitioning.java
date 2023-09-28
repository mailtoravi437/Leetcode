class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        
        solve(res,ans,s,0);
        return res;
    }
    
    public void solve(List<List<String>> res,List<String> ans,String s,int idx){
        if(idx==s.length()){
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                ans.add(s.substring(idx,i+1));
                solve(res,ans,s,i+1);
                ans.remove(ans.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s,int i,int j){
        int start = i;
        int end = j;
        
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            
            start++;
            end--;
        }
        
        return true;
    }
}