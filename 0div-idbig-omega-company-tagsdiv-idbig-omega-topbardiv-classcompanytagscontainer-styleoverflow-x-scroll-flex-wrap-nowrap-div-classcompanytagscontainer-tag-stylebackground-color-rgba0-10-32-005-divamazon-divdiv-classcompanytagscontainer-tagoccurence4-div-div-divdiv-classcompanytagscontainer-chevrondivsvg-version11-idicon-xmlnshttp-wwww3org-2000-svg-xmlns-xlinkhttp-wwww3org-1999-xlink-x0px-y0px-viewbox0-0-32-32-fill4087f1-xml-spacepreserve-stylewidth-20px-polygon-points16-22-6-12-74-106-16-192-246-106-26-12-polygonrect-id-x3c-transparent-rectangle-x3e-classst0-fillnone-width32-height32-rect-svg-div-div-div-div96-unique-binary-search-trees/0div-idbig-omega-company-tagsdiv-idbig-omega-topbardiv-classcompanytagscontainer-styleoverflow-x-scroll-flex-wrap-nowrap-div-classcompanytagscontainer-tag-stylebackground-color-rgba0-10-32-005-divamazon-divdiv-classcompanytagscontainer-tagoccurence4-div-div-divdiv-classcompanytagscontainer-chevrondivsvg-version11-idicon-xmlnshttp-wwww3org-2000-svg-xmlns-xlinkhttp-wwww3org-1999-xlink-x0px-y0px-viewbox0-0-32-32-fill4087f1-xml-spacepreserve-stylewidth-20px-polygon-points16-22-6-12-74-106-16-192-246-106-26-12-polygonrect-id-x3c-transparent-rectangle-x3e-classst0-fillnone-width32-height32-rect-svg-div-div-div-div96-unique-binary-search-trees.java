class Solution {
    Map<Integer,Integer> hmap = new HashMap<>();
    public int numTrees(int n) {
        if(n==0 || n==1){
            return 1;
        }
        
        int sum = 0;
        for(int i=1;i<=n;i++){
            if(!hmap.containsKey(i-1)){
                hmap.put(i-1,numTrees(i-1));
            }
            
            if(!hmap.containsKey(n-i)){
                hmap.put(n-i,numTrees(n-i));
            }
            
            sum += hmap.get(i-1)*hmap.get(n-i);
        }
        
        return sum;
    }
}