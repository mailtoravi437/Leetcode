class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0;
        long right = (long)Math.sqrt(c);
        
        while(left<=right){
            long curr = left*left+right*right;
            if(curr==c){
                return true;
            }
            
            if(curr<c){
                left++;
            }
            else{
                right--;
            }
        }
        
        return false;
    }
}