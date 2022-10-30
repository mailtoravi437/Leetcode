class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        int n = arr.length;
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> prev = new HashSet<>();
        
        for(int i=0;i<n;i++){
            HashSet<Integer> curr = new HashSet<>();
            curr.add(arr[i]);
            
            for(int x : prev){
                curr.add(arr[i]|x);
            }
            res.addAll(curr);
            
            prev = curr;
        }
        
        return res.size();
    }
}