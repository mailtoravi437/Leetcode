class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Boolean> hmap = new HashMap<>();
        return sol(s,wordDict,hmap);
    }
    
    public boolean sol(String s,List<String> wordDict,HashMap<String,Boolean> hmap){
        if(hmap.containsKey(s)){
            return hmap.get(s);
        }
        
        if(s.length()==0){
            return true;
        }
        
        for(String word : wordDict){
            if(s.startsWith(word)){
                if(sol(s.substring(word.length()),wordDict,hmap)){
                    hmap.put(word,true);
                    return true;
                }
            }
        }
        
        hmap.put(s,false);
        return false;
    }
}