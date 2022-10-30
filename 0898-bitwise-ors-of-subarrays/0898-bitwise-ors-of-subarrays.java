class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> prev = new HashSet<>();
        
        int n = arr.length;
        for(int i=0;i<n;i++){
            HashSet<Integer> curr = new HashSet<>();
            curr.add(arr[i]);
            for(int x : prev){
                curr.add(x|arr[i]);
            }
            
            prev = curr;
            res.addAll(curr);
        }
        
        return res.size();
    }
}