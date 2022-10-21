class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        HashSet<Integer> hset = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        while(!queue.isEmpty()){
            int i = queue.poll();
            if(arr[i]==0){
                return true;
            }
            
            if(hset.contains(i)){
                continue;
            }
            
            hset.add(i);
            
            if(i-arr[i]>=0){
                queue.add(i-arr[i]);
            }
            
            if(i+arr[i]<n){
                queue.add(i+arr[i]);
            }
        }
        
        return false;
    }
}