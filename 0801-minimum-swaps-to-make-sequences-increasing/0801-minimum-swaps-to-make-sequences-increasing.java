class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;
        
        int swap[] = new int[n];
        int nonswap[] = new int[n];
        
        swap[0] = 1;
        for(int i=1;i<n;i++){
            swap[i] = nonswap[i] = n;
            if(nums1[i-1]<nums1[i] && nums2[i-1]<nums2[i]){
                swap[i] = swap[i-1]+1;
                nonswap[i] = nonswap[i-1];
            }
            if(nums1[i-1]<nums2[i] && nums2[i-1]<nums1[i]){
                swap[i] = Math.min(nonswap[i-1]+1,swap[i]);
                nonswap[i] = Math.min(nonswap[i],swap[i-1]);
            }
        }
        
        return Math.min(swap[n-1],nonswap[n-1]);
    }
}