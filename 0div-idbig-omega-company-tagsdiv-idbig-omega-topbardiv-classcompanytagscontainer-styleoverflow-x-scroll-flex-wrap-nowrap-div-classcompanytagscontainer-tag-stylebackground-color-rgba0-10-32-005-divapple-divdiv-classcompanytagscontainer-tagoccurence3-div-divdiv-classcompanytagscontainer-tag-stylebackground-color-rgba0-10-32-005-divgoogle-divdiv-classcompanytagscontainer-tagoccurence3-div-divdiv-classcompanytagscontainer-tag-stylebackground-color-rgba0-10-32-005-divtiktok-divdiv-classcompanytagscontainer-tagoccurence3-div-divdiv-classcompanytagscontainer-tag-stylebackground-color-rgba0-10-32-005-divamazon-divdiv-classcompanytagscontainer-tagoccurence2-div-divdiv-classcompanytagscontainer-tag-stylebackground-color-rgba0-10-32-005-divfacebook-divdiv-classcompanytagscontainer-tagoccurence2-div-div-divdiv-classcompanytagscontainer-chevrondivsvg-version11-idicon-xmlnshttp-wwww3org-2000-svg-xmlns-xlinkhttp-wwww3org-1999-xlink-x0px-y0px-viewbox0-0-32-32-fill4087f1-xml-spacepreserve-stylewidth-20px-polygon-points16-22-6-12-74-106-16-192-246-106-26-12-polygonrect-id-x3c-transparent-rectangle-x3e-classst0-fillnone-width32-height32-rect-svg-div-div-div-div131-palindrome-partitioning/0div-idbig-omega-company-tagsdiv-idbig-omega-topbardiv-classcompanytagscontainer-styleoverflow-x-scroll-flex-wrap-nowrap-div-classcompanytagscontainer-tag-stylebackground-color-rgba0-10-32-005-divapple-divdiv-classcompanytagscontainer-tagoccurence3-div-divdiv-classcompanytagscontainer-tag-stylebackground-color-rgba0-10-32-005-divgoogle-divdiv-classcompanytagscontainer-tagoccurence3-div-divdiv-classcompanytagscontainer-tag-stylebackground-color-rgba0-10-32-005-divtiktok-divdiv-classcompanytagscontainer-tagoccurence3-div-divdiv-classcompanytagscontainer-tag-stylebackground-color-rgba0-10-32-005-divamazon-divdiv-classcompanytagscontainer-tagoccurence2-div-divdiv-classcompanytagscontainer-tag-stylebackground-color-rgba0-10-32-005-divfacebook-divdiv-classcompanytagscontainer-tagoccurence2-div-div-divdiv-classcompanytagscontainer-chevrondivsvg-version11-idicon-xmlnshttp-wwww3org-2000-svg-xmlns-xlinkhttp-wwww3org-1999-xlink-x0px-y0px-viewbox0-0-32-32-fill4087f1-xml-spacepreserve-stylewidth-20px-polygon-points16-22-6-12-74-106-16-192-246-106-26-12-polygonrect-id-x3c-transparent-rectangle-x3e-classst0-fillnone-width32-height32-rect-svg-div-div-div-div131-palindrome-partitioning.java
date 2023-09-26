class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();
        solve(s,ans,res,0);
        return ans;
    }
    
    public void solve(String s,List<List<String>> ans,List<String> res,int idx){
        if(idx==s.length()){
            ans.add(new ArrayList<>(res));
            return;
        }
        
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                res.add(s.substring(idx,i+1));
                solve(s,ans,res,i+1);
                res.remove(res.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s,int start,int end){
        int i = start;
        int j = end;
        
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
}