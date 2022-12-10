class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = Integer.MIN_VALUE;
        int n = sentences.length;
        for(int i=0;i<n;i++){
            int x = sentences[i].split(" ").length;
            max = Math.max(x,max);
        }
        
        return max;
    }
}