class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        
        int i=0;
        int j =n-1;
        
        int ans = Integer.MIN_VALUE;
        
        while(i<j){
            int lh = height[i];
            int rh = height[j];
            
            ans = Math.max(ans,Math.min(lh,rh)*(j-i));
            
            if(lh<rh){
                i++;
            }
            else{
                j--;
            }
        }
        
        return ans;
    }
}