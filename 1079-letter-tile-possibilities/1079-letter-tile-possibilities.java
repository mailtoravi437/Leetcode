class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> hset = new HashSet<>();
        char ch[] = tiles.toCharArray();
        boolean vis[] = new boolean[tiles.length()];
        sol(ch,hset,"",vis);
        return hset.size()-1;
    }
    
    public void sol(char ch[],Set<String> hset,String curr,boolean vis[]){
        hset.add(curr);
        for(int i=0;i<ch.length;i++){
            if(vis[i]==false){
                vis[i] = true;
                sol(ch,hset,curr+ch[i],vis);
                vis[i] = false;
            }
        }
    }
}