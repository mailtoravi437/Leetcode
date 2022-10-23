class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();
        sol(0,s,ans,res);
        return ans;
    }
    
    public void sol(int index,String s,List<List<String>> ans,List<String> res){
        if(index==s.length()){
            ans.add(new ArrayList<>(res));
            return;
        }
        
        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                res.add(s.substring(index,i+1));
                sol(i+1,s,ans,res);
                res.remove(res.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String str,int s,int e){
        while(s<=e){
            if(str.charAt(s)!=str.charAt(e)){
                return false;
            }
            
            s++;
            e--;
        }
        
        return true;
    }
}