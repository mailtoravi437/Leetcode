class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,new Comparator<int[]>(){
            public int compare(int a[],int b[]){
                return a[1]-b[1];
            }
        });
        
        int res = 1;
        int prev = 0;
        
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>pairs[prev][1]){
                res++;
                prev = i;
            }
        }
        
        return res;
    }
}