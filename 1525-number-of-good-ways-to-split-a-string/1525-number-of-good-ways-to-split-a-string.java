class Solution {
    public int numSplits(String s) {
        int n = s.length();
        HashMap<Character,Integer> right = new HashMap<>();
        HashMap<Character,Integer> left = new HashMap<>();
        
        for(int i=0;i<n;i++){
            right.put(s.charAt(i),right.getOrDefault(s.charAt(i),0)+1);
        }
        int count = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            left.put(ch,left.getOrDefault(ch,0)+1);
            right.put(ch,right.getOrDefault(ch,0)-1);
            
            
            if(right.get(ch)<=0){
                right.remove(ch);
            }
            
            if(left.size()==right.size()){
                count++;
            }
            
        }
        
        return count;
    }
}