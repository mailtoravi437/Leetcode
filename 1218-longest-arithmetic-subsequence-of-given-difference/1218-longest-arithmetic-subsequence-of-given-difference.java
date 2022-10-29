class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int n = arr.length;
        int ans = 0;
        HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<n;i++){
            int temp = 0;
            int required = arr[i]-difference;
            if(hmap.containsKey(required)){
                temp = hmap.get(required);
            }
            
            hmap.put(arr[i],temp+1);
            ans = Math.max(ans,temp+1);
        }
        
        return ans;
    }
}