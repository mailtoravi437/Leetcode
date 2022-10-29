class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int n = arr.length;
        int ans = 0;
        for(int i=0;i<n;i++){
            int required = arr[i]-difference;
            int temp = 0;
            if(hmap.containsKey(required)){
                temp = hmap.get(required);
            }
            
            hmap.put(arr[i],temp+1);
            ans = Math.max(ans,temp+1);
        }
        
        return ans;
    }
}