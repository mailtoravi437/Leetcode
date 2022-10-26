class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<n;i++){
            pq.add(nums[i]);
        }
        
        for(int i=1;i<k;i++){
            pq.poll();
        }
        
        return pq.peek();
    }
}