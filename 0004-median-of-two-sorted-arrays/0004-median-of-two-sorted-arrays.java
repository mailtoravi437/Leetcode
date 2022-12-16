class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length<nums1.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int low = 0;
        int high = n1;
        
        while(low<=high){
            int mid1 = (low+high)/2;
            int mid2 = (n1+n2)/2-mid1;
            
            int left1 = mid1==0?Integer.MIN_VALUE:nums1[mid1-1];
            int left2 = mid2==0?Integer.MIN_VALUE:nums2[mid2-1];
            
            int right1 = mid1==n1?Integer.MAX_VALUE:nums1[mid1];
            int right2 = mid2==n2?Integer.MAX_VALUE:nums2[mid2];
            
            
            if(left1>right2){
                high = mid1-1;
            }
            else if(left2>right1){
                low = mid1+1;
            }
            
            else{
                if((n1+n2)%2==0){
                    return (double)Math.max(left1,left2)*0.5+Math.min(right1,right2)*0.5;
                }
                else{
                    return (double)Math.min(right1,right2);
                }
            }
            
        }
        
        return 0.0;
    }
}