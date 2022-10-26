class Solution {
    public int[] sortArray(int[] nums) {
        
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    
    public void mergeSort(int nums[],int l,int r){
        if(l>=r){
            return;
        }
        
        int m = l+(r-l)/2;
        mergeSort(nums,l,m);
        mergeSort(nums,m+1,r);
        merge(nums,l,m,r);
    }
    
    public void merge(int nums[],int l,int m,int r){
        int merged[] = new int[r-l+1];
        int idx1 = l;
        int idx2 = m+1;
        int x = 0;
        
        
        while(idx1<=m && idx2<=r){
            if(nums[idx1]<nums[idx2]){
                merged[x++] = nums[idx1++];
            }
            else{
                merged[x++] = nums[idx2++];
            }
        }
        
        while(idx1<=m){
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