class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int meh[] = new int[n];
        meh[0] = arr[0];
        int max = arr[0];
        
        for(int i=1;i<n;i++){
            meh[i] = Math.max(meh[i-1]+arr[i],arr[i]);
            max = Math.max(meh[i],max);
        }
        
        int msh[] = new int[n];
        msh[n-1] = arr[n-1];
        
        for(int i=n-2;i>=0;i--){
            msh[i] = Math.max(msh[i+1]+arr[i],arr[i]);
            max = Math.max(max,msh[i]);
        }
        
        for(int i=1;i<n-1;i++){
            max = Math.max(max,msh[i+1]+meh[i-1]);
        }
        
        return max;
    }
}