class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            hmap.put(nums[i],hmap.getOrDefault(nums[i],0)+1);
        }
        
        for(Map.Entry<Integer,Integer> entry : hmap.entrySet()){
            if(entry.getValue()>nums.length/3){
                res.add(entry.getKey());
            }
        }
        
        return res;
    }
}