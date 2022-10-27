class Solution {
    public String reverseVowels(String s) {
        if(s.length()==0){
            return s;
        }
        
        char ch[] = s.toCharArray();
        String vowels = "aeiouAEIOU";
        
        int start = 0;
        int end = s.length()-1;
        
        while(start<end){
            while(start<end  && !vowels.contains(ch[start]+"")){
                start++;
            }
            
            while(start<end && !vowels.contains(ch[end]+"")){
                end--;
            }
            
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            
            start++;
            end--;
        }
        
        return new String(ch);
    }
}