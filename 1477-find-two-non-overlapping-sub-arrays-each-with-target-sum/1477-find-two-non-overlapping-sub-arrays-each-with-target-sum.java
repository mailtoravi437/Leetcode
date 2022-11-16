class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,-1);
        
        int lmin = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;
        
        int sum = 0;
        
        for(int i=0;i<n;i++){
            sum += arr[i];
            
            hmap.put(sum,i);
        }
        
        sum = 0;
        for(int i=0;i<n;i++){
            sum += arr[i];
            
            if(hmap.containsKey(sum-target)){
                lmin = Math.min(lmin,i-hmap.get(sum-target));
            }
            
            if(hmap.containsKey(sum+target) && lmin<Integer.MAX_VALUE){
                result = Math.min(result,lmin+hmap.get(sum+target)-i);
            }
        }
        
        return result==Integer.MAX_VALUE?-1:result;
    }
}