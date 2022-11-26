class Solution {
    public int findKthNumber(int m, int n, int k) {
        int low = 1;
        int high = m*n;
        
        while(low<=high){
            int mid = low+(high-low)/2;
            if(!sol(mid,m,n,k)){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        
        return low;
    }
    
    public boolean sol(int mid,int m,int n,int k){
        int count = 0;
        for(int i=1;i<=m;i++){
            count += Math.min(mid / i, n);
        }
        
        return count>=k;
    }
}