class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        int i=0;
        int j = 0;
        
        HashSet<Character> hset = new HashSet<>();
        while(i<n){
            if(!hset.contains(s.charAt(i))){
                hset.add(s.charAt(i));
                i++;
                ans = Math.max(ans,hset.size());
            }
            else{
                hset.remove(s.charAt(j));
                j++;
            }
            
            
        }
        
        return ans;
    }
}