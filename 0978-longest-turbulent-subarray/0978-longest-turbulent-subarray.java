class Solution {
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length==0){
            return 0;
        }
        
        int n = arr.length;
        int inc[] = new int[n];
        int dec[] = new int[n];
        
        Arrays.fill(inc,1);
        Arrays.fill(dec,1);
        
        int res = 1;
        
        for(int i=1;i<n;i++){
            if(arr[i-1]<arr[i]){
                inc[i] = dec[i-1]+1;
            }
            else if(arr[i-1]>arr[i]){
                dec[i] = inc[i-1]+1;
            }
            
            res = Math.max(res,Math.max(inc[i],dec[i]));
        }
        
        return res;
    }
}