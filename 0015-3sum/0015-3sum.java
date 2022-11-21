class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        
        int n = nums.length;
        if(n==0){
            return new ArrayList<>(res);
        }
        
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            int j = i+1;
            int k = n-1;
            
            while(j<k){
                int sum =  nums[i]+nums[j]+nums[k];
                if(sum==0){
                    res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                }
                
                else if(sum<0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        
        return new ArrayList<>(res);
    }
}