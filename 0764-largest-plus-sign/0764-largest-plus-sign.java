class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int arr[][] = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = 1;
            }
        }
        
        for(int[] mine : mines){
            arr[mine[0]][mine[1]] = 0;
        }
        
        int ans = 0;
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==1){
                    int order = 1;
                    while(true){
                        if(!isValid(i-order,j,arr)){
                            break;
                        }
                        
                        if(!isValid(i+order,j,arr)){
                            break;
                        }
                        
                        if(!isValid(i,j+order,arr)){
                            break;
                        }
                        
                        if(!isValid(i,j-order,arr)){
                            break;
                        }
                        
                        order++;
                    }
                                    ans = Math.max(ans,order);

                }
                
            }
        }
        
        return ans;
    }
    
    public boolean isValid(int i,int j,int arr[][]){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]!=1){
            return false;
        }
        
        return true;
    }
}