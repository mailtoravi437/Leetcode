class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()){
            return false;
        }
        
        HashMap<Character,Integer> hmap1 = new HashMap<>();
        HashMap<Character,Integer> hmap2 = new HashMap<>();
        
        for(int i=0;i<word1.length();i++){
            hmap1.put(word1.charAt(i),hmap1.getOrDefault(word1.charAt(i),0)+1);
        }
        
        for(int i=0;i<word2.length();i++){
            hmap2.put(word2.charAt(i),hmap2.getOrDefault(word2.charAt(i),0)+1);
        }
        
        if(!hmap1.keySet().equals(hmap2.keySet())){
            return false;
        }
        
        List<Integer> alist1 = new ArrayList<>(hmap1.values());
        List<Integer> alist2 = new ArrayList<>(hmap2.values());
        
        Collections.sort(alist1);
        Collections.sort(alist2);
        
        return alist1.equals(alist2);
    }
}