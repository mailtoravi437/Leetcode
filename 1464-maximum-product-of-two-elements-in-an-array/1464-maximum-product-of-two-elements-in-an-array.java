class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int a : nums){
            pq.add(a);
        }
        
        int ans = (pq.poll()-1)*(pq.poll()-1);
        return ans;
    }
}