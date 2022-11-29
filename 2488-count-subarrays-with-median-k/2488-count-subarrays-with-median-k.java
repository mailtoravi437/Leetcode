class Solution {
    public int countSubarrays(int[] nums, int k) {
        int sum = 0;
        int index = -1;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<k){
                nums[i] = -1;
            }
            else if(nums[i]>k){
                nums[i] = 1;
            }
            else{
                nums[i] = 0;
                index = i;
            }
        }
        
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int i=index;i>=0;i--){
            sum += nums[i];
            hmap.put(sum,hmap.getOrDefault(sum,0)+1);
        }
        
        sum = 0;
        int ans = 0;
        for(int i=index;i<n;i++){
            sum += nums[i];
            int f = -1*sum;
            
            if(hmap.containsKey(f)){
               ans += hmap.get(f); 
            }
            
            f += 1;
            if(hmap.containsKey(f)){
                ans += hmap.get(f);
            }
        }
        
        return ans;
    }
}