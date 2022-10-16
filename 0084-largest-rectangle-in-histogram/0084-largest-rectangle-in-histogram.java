class Solution {
    public int largestRectangleArea(int[] height) {
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        
        int ls[] = new int[n];
        int rs[] = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && height[st.peek()]>=height[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                ls[i] = 0;
            }
            else{
                ls[i] = st.peek()+1;
            }
            
            st.push(i);
        }
        
        st.clear();
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && height[st.peek()]>=height[i]){
                st.pop();
            }
            
            if(st.isEmpty()){
                rs[i] = n-1;
            }
            else{
                rs[i] = st.peek()-1;
            }
            
            st.push(i);
        }
        
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,(rs[i]-ls[i]+1)*height[i]);
        }
        
        return ans;
    }
}