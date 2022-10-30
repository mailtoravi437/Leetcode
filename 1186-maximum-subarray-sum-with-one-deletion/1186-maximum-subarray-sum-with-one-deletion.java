class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int mel[] = new int[n];
        int mer[] = new int[n];
        
        mel[0] = arr[0];
        int max = arr[0];
        
        for(int i=1;i<n;i++){
            mel[i] = Math.max(mel[i-1]+arr[i],arr[i]);
            max = Math.max(max,mel[i]);
        }
        
        mer[n-1] = arr[n-1];
        
        for(int i=n-2;i>=0;i--){
            mer[i] = Math.max(mer[i+1]+arr[i],arr[i]);
        }
        
        for(int i=1;i<n-1;i++){
            max = Math.max(max,mer[i+1]+mel[i-1]);
        }
        
        return max;
    }
}