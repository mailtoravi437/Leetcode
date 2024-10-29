class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<n;i++){
            hmap.put(nums[i],hmap.getOrDefault(nums[i],0)+1);
        }
        
        int res[] = new int[2];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry : hmap.entrySet()){
            if(entry.getValue()>=2){
                res[i] = entry.getKey();
                i++;
            }
            
        }
        
        return res;
    }
}