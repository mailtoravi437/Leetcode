class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(nums[n-1],0));
        for(int i=n-2;i>=0;i--){
            int count = 0;
            while(!st.isEmpty() && st.peek().value<nums[i]){
                count = Math.max(count+1,st.peek().count);
                                st.pop();


            }
            
            ans = Math.max(count,ans);
            st.push(new Pair(nums[i],count));
            
        }
        
        return ans;
    }
}

class Pair{
    int value;
    int count;
    
    Pair(int value,int count){
        this.value = value;
        this.count = count;
    }
}