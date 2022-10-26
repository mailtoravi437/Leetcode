class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    
    public void mergeSort(int nums[],int l,int r){
        if(l>=r){
            return;
        }
        
        int mid = l+(r-l)/2;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);
        
        merge(nums,l,mid,r);
    }
    
    public void merge(int nums[],int l,int mid,int r){
        int merged[] = new int[r-l+1];
        
        int idx1 = l;
        int idx2 = mid+1;
        
        int x = 0;
        
        while(idx1<=mid && idx2<=r){
            if(nums[idx1]<nums[idx2]){
                 merged[x++] = nums[idx1++];
            }
            else{
                merged[x++] = nums[idx2++];
            }
        }
        
        while(idx1<=mid){
            merged[x++] = nums[idx1++];
        }
        
        while(idx2<=r){
            merged[x++] = nums[idx2++];
        }
        
        for(int i=0,j=l;i<merged.length;i++,j++){
            nums[j] = merged[i];
        }
    }
}