class Solution {
    public char repeatedCharacter(String s) {
        HashMap<Character,Integer> hmap = new HashMap<>();
        char ans = 'a';
        for(int i=0;i<s.length();i++){
            hmap.put(s.charAt(i),hmap.getOrDefault(s.charAt(i),0)+1);
            if(hmap.get(s.charAt(i))==2){
                ans = s.charAt(i);
                break;
            }
        }
        
        return ans;
    }
}