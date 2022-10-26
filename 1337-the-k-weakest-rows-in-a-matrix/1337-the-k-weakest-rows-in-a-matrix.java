class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.index==b.index?b.row-a.row:b.index-a.index));
        
        for(int i=0;i<mat.length;i++){
            pq.add(new Pair(i,binarySearch(mat[i])));
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        int result[] = new int[k];
        while(!pq.isEmpty()){
            result[--k] = pq.poll().row;
        }
        
        return result;
        
    }
    
    public int binarySearch(int mat[]){
        
        int start = 0;
        int end = mat.length;
        
        while(start<end){
            int mid = start+(end-start)/2;
            if(mat[mid]==1){
                start = mid+1;
            }
            else{
                end = mid;
            }
        }
        
        return start;
    }
}

class Pair{
    int row;
    int index;
    
    Pair(int row,int index){
        this.row = row;
        this.index = index;
    }
}