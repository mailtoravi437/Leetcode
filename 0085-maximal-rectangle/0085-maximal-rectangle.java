class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        
        int height[] = new int[matrix[0].length];
        
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]=='1'){
                height[i] = 1;
            }
            
        }
        
        int res = largestInLine(height);
        
        for(int i=1;i<matrix.length;i++){
            resetHeight(height,i,matrix);
            res = Math.max(res,largestInLine(height));
        }
        
        return res;
    }
    
    public void resetHeight(int height[],int idx,char matrix[][]){
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[idx][i]=='1'){
                height[i] += 1;
            }
            else{
                height[i] = 0;
            }
        }
    }
    
    public int largestInLine(int height[]){
        int n = height.length;
        
        int ls[] = new int[n];
        int rs[] = new int[n];
        
        Stack<Integer> st = new Stack<>();
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