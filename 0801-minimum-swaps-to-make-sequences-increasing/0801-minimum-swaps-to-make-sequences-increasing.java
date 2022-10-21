class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        
        int swap[] = new int[n];
        int notswap[] = new int[n];
        
        swap[0] = 1;
        for(int i=1;i<n;i++){
            notswap[i] = swap[i]  = n;
            if(nums1[i-1]<nums1[i] && nums2[i-1]<nums2[i]){
                swap[i] = swap[i-1]+1;
                notswap[i] = notswap[i-1];
            }
            if(nums1[i-1]<nums2[i] && nums2[i-1]<nums1[i]){
                swap[i] = Math.min(notswap[i-1]+1,swap[i]);
                notswap[i] = Math.min(notswap[i],swap[i-1]);
            }
        }
        
        return Math.min(swap[n-1],notswap[n-1]);
    }
}