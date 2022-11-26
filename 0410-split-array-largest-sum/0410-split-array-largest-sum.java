class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = 0;
        int high = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            low = Math.max(low,nums[i]);
            high += nums[i];
        }
        
        while(low<=high){
            int mid = low+((high-low)>>2);
            if(requiredNum(mid,k,nums)){
                min = Math.min(min,mid);
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return min;
    }
    
    public boolean requiredNum(int mid,int k,int nums[]){
        int chunks =0;
        int i = 0;
        
        while(i<nums.length){
            int val = 0;
            while(i<nums.length && nums[i]+val<=mid){
                val += nums[i];
                i++;
            }
                chunks++;   
        }
        return chunks<=k;

    }
}