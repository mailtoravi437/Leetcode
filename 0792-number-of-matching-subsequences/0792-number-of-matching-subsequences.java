class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int n = words.length;
        HashMap<String,Integer> hmap = new HashMap<>();
        for(int i=0;i<n;i++){
            hmap.put(words[i],hmap.getOrDefault(words[i],0)+1);
        }
        
        int ans = 0;
        char ch[] = s.toCharArray();
        for(String str : hmap.keySet()){
            int i = 0;
            int j = 0;
            
            while(i<s.length() && j<str.length()){
                if(s.charAt(i)==str.charAt(j)){
                    i++;
                    j++;
                }
                else{
                    i++;
                }
                
                if(j==str.length()){
                    ans += hmap.get(str);
                }
            }
        }
        
        return ans;
    }
}