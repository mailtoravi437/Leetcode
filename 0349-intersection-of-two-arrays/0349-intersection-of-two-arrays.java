class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> hset1 = new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            hset1.add(nums1[i]);
        }
        
        Set<Integer> alist = new HashSet<>();
        for(int i=0;i<nums2.length;i++){
            if(hset1.contains(nums2[i])){
                alist.add(nums2[i]);
            }
        }
        
        int res[] = new int[alist.size()];
        int i = 0;
        for(int x : alist){
            res[i++] = x;
        }
        
        return res;
    }
}