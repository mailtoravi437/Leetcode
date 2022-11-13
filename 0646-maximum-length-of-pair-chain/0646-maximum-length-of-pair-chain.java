class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int prev = Integer.MIN_VALUE;
        
        int count = 0;
        
        for(int pair[] : pairs){
            if(prev<pair[0]){
                count++;
                            prev = pair[1];

            }
        }
        
        return count;
    }
}