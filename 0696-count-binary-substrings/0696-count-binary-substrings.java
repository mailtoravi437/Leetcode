class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int curr = 1,pre = 0,res = 0;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                curr++;
            }
            else{
                 res += Math.min(curr,pre);
                    pre = curr;
                    curr = 1; 
            }
            
          
        }
                
        return res+Math.min(curr,pre);
    }
}