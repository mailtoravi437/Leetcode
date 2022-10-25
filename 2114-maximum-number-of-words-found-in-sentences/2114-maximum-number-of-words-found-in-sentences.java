class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans = 0;
        int maxans = 0;
        for(String str : sentences){
            String str1[] = str.split(" ");
            ans = str1.length;
            maxans = Math.max(maxans,ans);
        }
        
        return maxans;
    }
}