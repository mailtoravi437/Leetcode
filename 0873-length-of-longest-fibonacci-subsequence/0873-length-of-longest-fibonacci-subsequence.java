class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        HashSet<Integer> hset = new HashSet<>();
        for(int i=0;i<n;i++){
            hset.add(arr[i]);
        }
        
        int max = 0;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int a = arr[i];
                int b = arr[j];
                
                int c = a+b;
                
                if(hset.contains(c)){
                    count = 2;
                    
                }
                
                while(hset.contains(c)){
                    count++;
                    a = b;
                    b = c;
                    c = a+b;
                }
                max = Math.max(max,count);
            }
        }
        
        return max;
    }
}